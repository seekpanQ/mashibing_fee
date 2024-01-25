package com.mashibing.servicedriveruser.service;

import com.mashibing.internalcommon.dto.Car;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.responese.TerminalResponse;
import com.mashibing.servicedriveruser.mapper.CarMapper;
import com.mashibing.servicedriveruser.remote.ServiceMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CarService {
    @Autowired
    private CarMapper carMapper;

    @Autowired
    private ServiceMapClient serviceMapClient;

    public ResponseResult addCar(Car car) {
        // 获得此车辆 对应 的 tid
        String vehicleNo = car.getVehicleNo();
        ResponseResult<TerminalResponse> terminalResponseResponseResult = serviceMapClient.addTerminal(vehicleNo);
        TerminalResponse terminalResponse = terminalResponseResponseResult.getData();
        String tid = terminalResponse.getTid();
        car.setTid(tid);
        LocalDateTime now = LocalDateTime.now();
        car.setGmtModified(now);
        car.setGmtCreate(now);
        carMapper.insert(car);
        return ResponseResult.success("");
    }
}
