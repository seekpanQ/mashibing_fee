package com.mashibing.internalcommon.request;

import com.mashibing.internalcommon.dto.PointDTO;
import lombok.Data;

@Data
public class ApiDriverPointRequest {

    private Long carId;

    private PointDTO[] points;
}
