package com.mashibing.internalcommon.responese;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class TerminalResponse {
    private String tid;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long carId;

    private String longitude;
    private String latitude;
}
