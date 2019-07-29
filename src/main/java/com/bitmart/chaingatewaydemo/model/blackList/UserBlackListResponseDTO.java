package com.bitmart.chaingatewaydemo.model.blackList;

import com.bitmart.chain.grpc.dto.backend.UserBlackListDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserBlackListResponseDTO {
    private Boolean isSuccess_;

    private String errCode_;

    private String errMsg_;

    private Integer totalPage_;

    private Integer totalCount_;

    private List<UserBlackListResponseDataDTO> userBlackListInfo_;

    private UserBlackListResponseDataDTO userBlackInfo;

}
