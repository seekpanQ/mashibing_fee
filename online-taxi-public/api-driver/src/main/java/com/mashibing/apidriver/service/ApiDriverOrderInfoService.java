package com.mashibing.apidriver.service;

import com.mashibing.apidriver.remote.ServiceOrderClient;
import com.mashibing.internalcommon.constant.IdentityConstants;
import com.mashibing.internalcommon.dto.OrderInfo;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiDriverOrderInfoService {

    @Autowired
    private ServiceOrderClient serviceOrderClient;

    public ResponseResult toPickUpPassenger(OrderRequest orderRequest) {

        return serviceOrderClient.toPickUpPassenger(orderRequest);
    }

    public ResponseResult arrivedDeparture(OrderRequest orderRequest) {
        return serviceOrderClient.arrivedDeparture(orderRequest);
    }

    /**
     * 司机接到乘客
     *
     * @param orderRequest
     * @return
     */
    public ResponseResult pickUpPassenger(OrderRequest orderRequest) {
        return serviceOrderClient.pickUpPassenger(orderRequest);
    }

    public ResponseResult passengerGetoff(OrderRequest orderRequest) {
        return serviceOrderClient.passengerGetoff(orderRequest);
    }

    public ResponseResult cancel(Long orderId) {
        return serviceOrderClient.cancel(orderId, IdentityConstants.DRIVER_IDENTITY);
    }

    public ResponseResult<OrderInfo> detail(Long orderId) {
        return serviceOrderClient.detail(orderId);
    }

    public ResponseResult<OrderInfo> currentOrder(String phone, String driverIdentity) {
        return serviceOrderClient.current(phone, driverIdentity);
    }
}
