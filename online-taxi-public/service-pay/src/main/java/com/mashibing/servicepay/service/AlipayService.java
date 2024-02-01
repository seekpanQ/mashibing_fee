package com.mashibing.servicepay.service;

import com.mashibing.internalcommon.request.OrderRequest;
import com.mashibing.servicepay.remote.ServiceOrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlipayService {

    @Autowired
    private ServiceOrderClient serviceOrderClient;

    public void pay(Long orderId) {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderId(orderId);
        serviceOrderClient.pay(orderRequest);
    }

}
