package com.bitmart.chaingatewaydemo.service;

import com.bitmart.chaingatewaydemo.enums.SysErrorWarnType;
import com.bitmart.chaingatewaydemo.model.blackList.UserBlackListResponseDTO;
import com.bitmart.chaingatewaydemo.model.common.CommonResponseDTO;
import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigQueryDTO;
import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigResponseDTO;
import com.bitmart.chaingatewaydemo.service.grpc.GatewayConfigGrpcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GatewayConfigService {
    @Autowired
    private GatewayConfigGrpcService gatewayConfigGrpcService;

    @Autowired
    private CheckService checkService;

    public GatewayConfigResponseDTO gatewayConfigQuery(GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        GatewayConfigResponseDTO response = new GatewayConfigResponseDTO();
        if (checkService.intCheck(gatewayConfigQueryDTO.getPage()) && checkService.intCheck(gatewayConfigQueryDTO.getPageSize()) &&
                gatewayConfigQueryDTO.getPage() >= 0 && gatewayConfigQueryDTO.getPageSize() > 0) {
            response = gatewayConfigGrpcService.gatewayConfigQuery(gatewayConfigQueryDTO);
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public GatewayConfigResponseDTO gatewayConfigSingleQuery(GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        GatewayConfigResponseDTO response = new GatewayConfigResponseDTO();
        if (checkService.stringCheck(gatewayConfigQueryDTO.getInterfaceCode()) && checkService.intCheck((gatewayConfigQueryDTO.getChainId()))) {
            response = gatewayConfigGrpcService.gatewayConfigSingleQuery(gatewayConfigQueryDTO);
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public GatewayConfigResponseDTO gatewayConfigCreate(GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        GatewayConfigResponseDTO response = new GatewayConfigResponseDTO();
        if (checkService.stringCheck(gatewayConfigQueryDTO.getInterfaceCode()) &&
                checkService.intCheck(gatewayConfigQueryDTO.getChainId()) &&
                checkService.stringCheck(gatewayConfigQueryDTO.getChainName()) &&
                checkService.stringCheck(gatewayConfigQueryDTO.getRequestUrl()) &&
                checkService.stringCheck(gatewayConfigQueryDTO.getOper())) {
            response = gatewayConfigGrpcService.gatewayConfigCreate(gatewayConfigQueryDTO);
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public GatewayConfigResponseDTO gatewayConfigUpdate(GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        GatewayConfigResponseDTO response = new GatewayConfigResponseDTO();
        if (checkService.intCheck(gatewayConfigQueryDTO.getId())) {
            response = gatewayConfigGrpcService.gatewayConfigUpdate(gatewayConfigQueryDTO);
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    private void setParamError(GatewayConfigResponseDTO response) {
        response.setIsSuccess_(false);
        response.setErrMsg_(SysErrorWarnType.GATEWAY_PARAM_ERROR.getMsg());
        response.setErrCode_(SysErrorWarnType.GATEWAY_PARAM_ERROR.getCode().toString());
        log.error("Error code is : " + SysErrorWarnType.GATEWAY_PARAM_ERROR.getCode().toString() + ", and error message is : "
                + SysErrorWarnType.GATEWAY_PARAM_ERROR.getMsg());
    }

    private void setResponseError(GatewayConfigResponseDTO response) {
        if (response == null ) {
            response.setIsSuccess_(false);
            response.setErrCode_(SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getCode().toString());
            response.setErrMsg_(SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getMsg());
            log.error("Error code is : " + SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getCode().toString() + ", and error message is : "
                    + SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getMsg());
        }else if (response.getIsSuccess_() == false){
           log.error("Error code is : " + response.getErrCode_() + ", and error message is : "
                   + response.getErrMsg_());
        }
    }
}
