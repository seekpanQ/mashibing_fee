package com.mashibing.apidriver.remote;

import com.mashibing.internalcommon.dto.*;
import com.mashibing.internalcommon.responese.DriverUserExistsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser);

    @GetMapping("/check-driver/{driverPhone}")
    public ResponseResult<DriverUserExistsResponse> checkDriver(@PathVariable("driverPhone") String driverPhone);

    @GetMapping("/car")
    public ResponseResult<Car> getCarById(@RequestParam Long carId);

    @PostMapping("/driver-user-work-status")
    public ResponseResult changeWorkStatus(@RequestBody DriverUserWorkStatus driverUserWorkStatus);

    @GetMapping("/driver-car-binding-relationship")
    public ResponseResult<DriverCarBindingRelationship> getDriverCarRelationShip(@RequestParam String driverPhone);

    @GetMapping("/work-status")
    public ResponseResult<DriverUserWorkStatus> getWorkStatus(@RequestParam Long driverId);
}
