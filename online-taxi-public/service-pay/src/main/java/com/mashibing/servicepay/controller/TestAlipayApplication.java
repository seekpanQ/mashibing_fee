package com.mashibing.servicepay.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAlipayApplication {

    @PostMapping("/test")
    public String test() {

        System.out.println("支付宝回调啦");
        return "外网穿透测试";
    }
}
