package com.bitmart.chaingatewaydemo.model.blackList;

import lombok.*;

import java.math.BigInteger;

@Data
public class UserBlackListQueryDTO {
    private String correlationID;

    private Integer id;

    private Integer page;

    private Integer pageSize;

    private String blackName;

    private Integer blackType;

    private Boolean deleted;

    private String describe;

    private String oper;
}
