package com.bitmart.chaingatewaydemo.model.utxo;

import lombok.Data;

@Data
public class UtxoDTO {
    private int id;

    private int chainId;

    private Boolean success;
}
