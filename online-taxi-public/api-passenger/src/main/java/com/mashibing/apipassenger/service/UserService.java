package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.ServicePassengerUserClient;
import com.mashibing.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ServicePassengerUserClient servicePassengerUserClient;

    /**
     * 根据手机号查询用户信息
     *
     * @param passengerPhone
     * @return
     */
    public ResponseResult getUserByPhone(String passengerPhone) {
        // 根据手机号查询用户信息
        return servicePassengerUserClient.getUser(passengerPhone);
    }
}
