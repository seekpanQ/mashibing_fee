package com.mashibing.internalcommon.request;

import com.mashibing.internalcommon.dto.PointDTO;
import lombok.Data;

@Data
public class PointRequest {
    private String tid;

    private String trid;

    private PointDTO[] points;
}
