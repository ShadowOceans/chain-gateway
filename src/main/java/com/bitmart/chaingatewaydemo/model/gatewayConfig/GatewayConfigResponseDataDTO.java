package com.bitmart.chaingatewaydemo.model.gatewayConfig;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class GatewayConfigResponseDataDTO {

    private Integer chainId;

    private String chainName;

    private Timestamp createdAt;

    private String requestUrl;

    private String describe;

    private Integer id;

    private String interfaceCode;

    private Boolean news;

    private Boolean status;

    private Timestamp updatedAt;

    private String updatedBy;


}
