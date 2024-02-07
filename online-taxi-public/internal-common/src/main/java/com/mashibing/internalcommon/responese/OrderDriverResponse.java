package com.mashibing.internalcommon.responese;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class OrderDriverResponse {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long driverId;

    private String driverPhone;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long carId;

    /**
     * 机动车驾驶证号
     */
    private String licenseId;

    /**
     * 车辆号牌
     */
    private String vehicleNo;
    /**
     * 车辆类型
     */
    private String vehicleType;
}
