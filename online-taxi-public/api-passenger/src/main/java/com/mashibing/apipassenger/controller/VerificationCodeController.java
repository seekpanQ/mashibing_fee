package com.mashibing.apipassenger.controller;

import com.mashibing.apipassenger.request.CheckVerificationCodeDTO;
import com.mashibing.apipassenger.request.SendVerificationCodeDTO;
import com.mashibing.apipassenger.service.VerificationCodeService;
import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @PostMapping("/verification-code")
    public ResponseResult verificationCode(@Validated @RequestBody SendVerificationCodeDTO verificationCodeDTO) {

        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        return verificationCodeService.generateCode(passengerPhone);
    }

    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@Validated @RequestBody CheckVerificationCodeDTO checkVerificationCodeDTO) {

        String passengerPhone = checkVerificationCodeDTO.getPassengerPhone();
        String verificationCode = checkVerificationCodeDTO.getVerificationCode();

        System.out.println("手机号" + passengerPhone + ",验证码：" + verificationCode);

        return verificationCodeService.checkCode(passengerPhone, verificationCode);
    }

}
