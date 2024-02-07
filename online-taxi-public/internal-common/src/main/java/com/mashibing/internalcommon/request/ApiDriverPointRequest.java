package com.mashibing.internalcommon.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mashibing.internalcommon.dto.PointDTO;
import lombok.Data;

@Data
public class ApiDriverPointRequest {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long carId;

    private PointDTO[] points;
}
