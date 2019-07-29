package com.bitmart.chaingatewaydemo.model.gatewayConfig;

import com.bitmart.chain.grpc.dto.backend.GatewayConfigDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GatewayConfigResponseDTO {

    //多条查询的返回的结果
    private List<GatewayConfigResponseDataDTO> gatewayConfigListInfo_;

    private Boolean isSuccess_;

    private String errCode_;

    private String errMsg_;

    private Integer totalPage_;

    private Integer totalCount_;

    //单条查询的返回结果
    private GatewayConfigResponseDataDTO gatewayConfigInfo_;


}
