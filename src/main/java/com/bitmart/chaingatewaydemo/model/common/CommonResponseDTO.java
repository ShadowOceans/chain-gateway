package com.bitmart.chaingatewaydemo.model.common;

import lombok.Data;

@Data
public class CommonResponseDTO {

    private String code;

    private Boolean success;

    private String message;

    private Boolean completeConsistent;

    private Integer inconsistentSize;

}
