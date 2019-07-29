package com.bitmart.chaingatewaydemo.service;

import com.bitmart.chaingatewaydemo.enums.SysErrorWarnType;
import com.bitmart.chaingatewaydemo.model.blackList.UserBlackListQueryDTO;
import com.bitmart.chaingatewaydemo.model.blackList.UserBlackListResponseDTO;
import com.bitmart.chaingatewaydemo.model.common.CommonResponseDTO;
import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigResponseDTO;
import com.bitmart.chaingatewaydemo.service.grpc.BlackListGrpcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BlackListService {
    @Autowired
    private BlackListGrpcService blackListGrpcService;

    @Autowired
    private CheckService checkService;

    public UserBlackListResponseDTO blackListConfigQuery(UserBlackListQueryDTO userBlackListQueryDTO) {
        UserBlackListResponseDTO response = new UserBlackListResponseDTO();
        if (checkService.intCheck(userBlackListQueryDTO.getPage()) && checkService.intCheck(userBlackListQueryDTO.getPageSize())) {
            response = blackListGrpcService.gatewayConfigQuery(userBlackListQueryDTO);
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public UserBlackListResponseDTO blackListCreate(UserBlackListQueryDTO userBlackListQueryDTO) {
        UserBlackListResponseDTO response = new UserBlackListResponseDTO();
        if (checkService.stringCheck(userBlackListQueryDTO.getBlackName()) &&
                checkService.intCheck(userBlackListQueryDTO.getBlackType()) &&
                checkService.stringCheck(userBlackListQueryDTO.getOper())) {
            response = blackListGrpcService.blackListCreate(userBlackListQueryDTO);
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public UserBlackListResponseDTO blackListUpdate(UserBlackListQueryDTO userBlackListQueryDTO) {
        UserBlackListResponseDTO response = new UserBlackListResponseDTO();
        if (checkService.intCheck(userBlackListQueryDTO.getId())) {
            response = blackListGrpcService.blackListUpdate(userBlackListQueryDTO);
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    private void setParamError(UserBlackListResponseDTO response) {
        response.setIsSuccess_(false);
        response.setErrMsg_(SysErrorWarnType.GATEWAY_PARAM_ERROR.getMsg());
        response.setErrCode_(SysErrorWarnType.GATEWAY_PARAM_ERROR.getCode().toString());
        log.error("Error code is : " + SysErrorWarnType.GATEWAY_PARAM_ERROR.getCode().toString() + ", and error message is : "
                + SysErrorWarnType.GATEWAY_PARAM_ERROR.getMsg());
    }

    private void setResponseError(UserBlackListResponseDTO response) {
        if (response == null) {
            response.setIsSuccess_(false);
            response.setErrCode_(SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getCode().toString());
            response.setErrMsg_(SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getMsg());
            log.error("Error code is : " + SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getCode().toString() + ", and error message is : "
                    + SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getMsg());
        } else if (response.getIsSuccess_() == false)
            log.error("Error code is : " + response.getErrCode_() + ", and error message is : "
                    + response.getErrMsg_());
    }
}
