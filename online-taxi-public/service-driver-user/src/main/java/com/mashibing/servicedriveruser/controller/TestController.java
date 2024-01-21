package com.mashibing.servicedriveruser.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.servicedriveruser.service.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DriverUserService driverUserService;


    @RequestMapping("/test")
    public String test() {
        return "service-driver-user";
    }

    @GetMapping("test-db")
    public ResponseResult testDb() {
        return driverUserService.testGetDriverUser();
    }
}
