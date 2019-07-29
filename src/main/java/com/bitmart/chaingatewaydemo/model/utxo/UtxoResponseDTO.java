package com.bitmart.chaingatewaydemo.model.utxo;

import lombok.Data;

@Data
public class UtxoResponseDTO {
    private Boolean data;

    private Boolean success;

    private String code;

    private String message;
}
