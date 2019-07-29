package com.bitmart.chaingatewaydemo.model.common;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CommonDTO {

    private String interfaceCode;

    private Integer ChainId;

    private Integer tokenId;

    private Integer index;

    private String oper;

    private String address;

    private String txid;

    private Long userId;

    private Long beginHeight;

    private Long endHeight;

    private Long requestId;

    private BigDecimal diffBalance;

}
