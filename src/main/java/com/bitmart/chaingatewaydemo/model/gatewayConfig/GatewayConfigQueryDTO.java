package com.bitmart.chaingatewaydemo.model.gatewayConfig;

import lombok.Data;

@Data
public class GatewayConfigQueryDTO {

    private String correlationID;

    private String interfaceCode;

    private Integer page;

    private  Integer pageSize;

    private Integer id;

    private Integer chainId;

    private String chainName;

    private  String requestUrl;

    private String describe;

    private String oper;

    private String status;

}
