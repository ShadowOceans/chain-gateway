package com.bitmart.chaingatewaydemo.model.blackList;

import lombok.Data;

@Data
public class UserBlackListResponseDataDTO {

    private Integer blackType;

    private String createdAt;

    private Boolean news;

    private Boolean deleted;

    private Integer id;

    private String blacName;

    private String updatedAt;

}
