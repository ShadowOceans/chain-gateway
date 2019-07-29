package com.bitmart.chaingatewaydemo.service;

import com.bitmart.chaingatewaydemo.enums.InterfaceCodeEnum;
import com.bitmart.chaingatewaydemo.enums.SysErrorWarnType;
import com.bitmart.chaingatewaydemo.model.index.IndexResponseDTO;
import com.bitmart.chaingatewaydemo.model.utxo.UtxoDTO;
import com.bitmart.chaingatewaydemo.model.utxo.UtxoResponseDTO;
import com.bitmart.chaingatewaydemo.service.http.RequestHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtxoService {

    @Autowired
    private CheckService checkService;

    @Autowired
    private RequestHttpService requestHttpService;

    public UtxoResponseDTO utxoSpentService(UtxoDTO utxoDTO) {
        UtxoResponseDTO response = new UtxoResponseDTO();
        if (checkService.intCheck(utxoDTO.getChainId()) && checkService.intCheck(utxoDTO.getId()) && checkService.booleanCheck(utxoDTO.getSuccess())) {
            response = requestHttpService.sent(InterfaceCodeEnum.UTXO_SPENT.getName(),
                    utxoDTO.getChainId(), "/" + utxoDTO.getId() + "/" + utxoDTO.getSuccess(), UtxoResponseDTO.class, HttpMethod.GET,"utxo");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public UtxoResponseDTO utxoLockService(UtxoDTO utxoDTO) {
        UtxoResponseDTO response = new UtxoResponseDTO();
        if (checkService.intCheck(utxoDTO.getChainId()) && checkService.intCheck(utxoDTO.getId()) && checkService.booleanCheck(utxoDTO.getSuccess())) {
            response = requestHttpService.sent(InterfaceCodeEnum.UTXO_LOCK.getName(),
                    utxoDTO.getChainId(), "/" + utxoDTO.getId() + "/" + utxoDTO.getSuccess(), UtxoResponseDTO.class, HttpMethod.GET,"utxo");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public UtxoResponseDTO utxoMergeService(UtxoDTO utxoDTO) {
        UtxoResponseDTO response = new UtxoResponseDTO();
        if (checkService.intCheck(utxoDTO.getChainId())) {
            response = requestHttpService.sent(InterfaceCodeEnum.UTXO_MERGE.getName(),
                    utxoDTO.getChainId(), "", UtxoResponseDTO.class, HttpMethod.GET,"utxo");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    private void setParamError(UtxoResponseDTO response) {
        response.setSuccess(false);
        response.setCode(SysErrorWarnType.GATEWAY_PARAM_ERROR.getCode().toString());
        response.setMessage(SysErrorWarnType.GATEWAY_PARAM_ERROR.getMsg());
        log.error("Error code is : " + SysErrorWarnType.GATEWAY_PARAM_ERROR.getCode().toString() + ", and error message is : "
                + SysErrorWarnType.GATEWAY_PARAM_ERROR.getMsg());
    }

    private void setResponseError(UtxoResponseDTO response) {
        if (response == null) {
            response.setSuccess(false);
            response.setCode(SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getCode().toString());
            response.setMessage(SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getMsg());
            log.error("Error code is : " + SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getCode().toString() + ", and error message is : "
                    + SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getMsg());
        } else if (response.getSuccess() == false)
            log.error("Error code is : " + response.getCode() + ", and error message is : "
                    + response.getMessage());
        else {
            response.setCode("0000");
            response.setMessage("success");
        }
    }

}
