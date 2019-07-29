package com.bitmart.chaingatewaydemo.model.index;

import lombok.Data;

@Data
public class IndexResponseDTO {
    private String code;

    private String message;

    private String [] data;

    private IndexErrorDTO error;

    private Boolean success;
}
