package com.mashibing.serviceorder.controller;


import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.request.OrderRequest;
import com.mashibing.serviceorder.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Lison
 * @since 2024-01-25
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @PostMapping("/add")
    public ResponseResult add(@RequestBody OrderRequest orderRequest) {
        log.info("service-order" + orderRequest.getAddress());
        return orderInfoService.add(orderRequest);
    }

    /**
     * 去接乘客
     *
     * @param orderRequest
     * @return
     */
    @PostMapping("/to-pick-up-passenger")
    public ResponseResult changeStatus(@RequestBody OrderRequest orderRequest) {

        return orderInfoService.toPickUpPassenger(orderRequest);
    }

    /**
     * 到达乘客上车点
     *
     * @param orderRequest
     * @return
     */
    @PostMapping("/arrived-departure")
    public ResponseResult arrivedDeparture(@RequestBody OrderRequest orderRequest) {
        return orderInfoService.arrivedDeparture(orderRequest);
    }

    /**
     * 司机接到乘客
     *
     * @param orderRequest
     * @return
     */
    @PostMapping("/pick-up-passenger")
    public ResponseResult pickUpPassenger(@RequestBody OrderRequest orderRequest) {
        return orderInfoService.pickUpPassenger(orderRequest);
    }

    /**
     * 乘客到达目的地，行程终止
     *
     * @param orderRequest
     * @return
     */
    @PostMapping("/passenger-getoff")
    public ResponseResult passengerGetoff(@RequestBody OrderRequest orderRequest) {
        return orderInfoService.passengerGetoff(orderRequest);
    }

    /**
     * 支付完成
     *
     * @param orderRequest
     * @return
     */
    @PostMapping("/pay")
    public ResponseResult pay(@RequestBody OrderRequest orderRequest) {

        return orderInfoService.pay(orderRequest);
    }

    /**
     * 订单取消
     *
     * @param orderId
     * @param identity
     * @return
     */
    @PostMapping("/cancel")
    public ResponseResult cancel(@RequestParam Long orderId, @RequestParam String identity) {

        return orderInfoService.cancel(orderId, identity);
    }
}
