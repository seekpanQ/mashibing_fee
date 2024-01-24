package com.mashibing.apidriver.service;

import com.mashibing.apidriver.remote.ServiceDriverUserClient;
import com.mashibing.apidriver.remote.ServiceVefificationcodeClient;
import com.mashibing.internalcommon.constant.CommonStatusEnum;
import com.mashibing.internalcommon.constant.DriverCarConstants;
import com.mashibing.internalcommon.constant.IdentityConstants;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.responese.DriverUserExistsResponse;
import com.mashibing.internalcommon.responese.NumberCodeResponse;
import com.mashibing.internalcommon.util.RedisPrefixUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class VerificationCodeService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;
    @Autowired
    private ServiceVefificationcodeClient serviceVefificationcodeClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public ResponseResult checkAndsendVerificationCode(String driverPhone) {
        // 查询 service-driver-user，该手机号的司机是否存在
        ResponseResult<DriverUserExistsResponse> driverUserExistsResponseResponseResult
                = serviceDriverUserClient.checkDriver(driverPhone);
        DriverUserExistsResponse data = driverUserExistsResponseResponseResult.getData();
        int ifExists = data.getIfExists();
        if (ifExists == DriverCarConstants.DRIVER_NOT_EXISTS) {
            return ResponseResult.fail(CommonStatusEnum.DRIVER_NOT_EXITST.getCode(), CommonStatusEnum.DRIVER_NOT_EXITST.getValue());
        }
        log.info(driverPhone + " 的司机存在");

        // 获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResult = serviceVefificationcodeClient.getNumberCode(6);
        NumberCodeResponse numberCodeResponse = numberCodeResult.getData();
        int numberCode = numberCodeResponse.getNumberCode();
        log.info("验证码" + numberCode);

        // 调用第三方发生验证码,第三方：阿里短信服务，腾讯，华信，容联

        // 存入reids。1：key，2：存入value
        String key = RedisPrefixUtils.generatorKeyByPhone(driverPhone, IdentityConstants.DRIVER_IDENTITY);
        stringRedisTemplate.opsForValue().set(key, numberCode + "", 2, TimeUnit.MINUTES);

        return ResponseResult.success("");
    }


}
