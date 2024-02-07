package com.mashibing.servicedriveruser.controller;


import com.mashibing.internalcommon.dto.Car;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.servicedriveruser.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Lison
 * @since 2024-01-22
 */
@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/car")
    public ResponseResult addCar(@RequestBody Car car) {

        return carService.addCar(car);
    }

    @GetMapping("/car")
    public ResponseResult<Car> getCarById(@RequestParam Long carId) {

        return carService.getCarById(carId);
    }

}
