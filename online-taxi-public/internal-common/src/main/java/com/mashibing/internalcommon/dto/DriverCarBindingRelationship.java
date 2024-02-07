package com.mashibing.internalcommon.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Lison
 * @since 2024-01-22
 */
@Data
public class DriverCarBindingRelationship implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long driverId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long carId;

    private Integer bindState;

    private LocalDateTime bindingTime;

    private LocalDateTime unBindingTime;
}
