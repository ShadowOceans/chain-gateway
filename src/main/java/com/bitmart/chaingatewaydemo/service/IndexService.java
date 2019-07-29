package com.bitmart.chaingatewaydemo.service;

import com.bitmart.chaingatewaydemo.enums.InterfaceCodeEnum;
import com.bitmart.chaingatewaydemo.enums.SysErrorWarnType;
import com.bitmart.chaingatewaydemo.model.common.CommonResponseDTO;
import com.bitmart.chaingatewaydemo.model.index.IndexDTO;
import com.bitmart.chaingatewaydemo.model.index.IndexResponseDTO;
import com.bitmart.chaingatewaydemo.service.http.RequestHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IndexService {

    @Autowired
    private RequestHttpService requestHttpService;

    @Autowired
    private CheckService checkService;

    public IndexResponseDTO indexAddressService(IndexDTO indexDTO) {
        IndexResponseDTO response = new IndexResponseDTO();
        if (checkService.intCheck(indexDTO.getChainId())) {
            response = requestHttpService.sent(InterfaceCodeEnum.INDEX_ADDRESSES.getName(),
                    indexDTO.getChainId(), "", IndexResponseDTO.class, HttpMethod.GET,"index");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public IndexResponseDTO resyncUtxoService(IndexDTO indexDTO) {
        IndexResponseDTO response = new IndexResponseDTO();
        if (checkService.intCheck(indexDTO.getChainId()) && checkService.stringCheck(indexDTO.getTxid())) {
            response = requestHttpService.sent(InterfaceCodeEnum.INDEX_RESYNC_UTXO.getName(),
                    indexDTO.getChainId(), "/" + indexDTO.getTxid(), IndexResponseDTO.class, HttpMethod.GET,"index");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public IndexResponseDTO resyncTxService(IndexDTO indexDTO) {
        IndexResponseDTO response = new IndexResponseDTO();
        if (checkService.intCheck(indexDTO.getChainId()) && checkService.stringCheck(indexDTO.getTxid())) {
            response = requestHttpService.sent(InterfaceCodeEnum.INDEX_RESYNC_TX.getName(),
                    indexDTO.getChainId(), "/" + indexDTO.getTxid(), IndexResponseDTO.class, HttpMethod.GET,"index");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    private void setResponseError(IndexResponseDTO response) {
        if (response == null) {
            response.setSuccess(false);
            response.setCode(SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getCode().toString());
            response.setMessage(SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getMsg());
            log.error("Error code is : " + SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getCode().toString() + ", and error message is : "
                    + SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getMsg());
        } else if (response.getSuccess() == false)
            log.error("Error desc is : " +response.getError().getDesc()+ ", and error message is : "
                    + response.getError().getError());
     else {
            response.setCode("0000");
            response.setMessage("success");
        }
    }

    private void setParamError(IndexResponseDTO response) {
        response.setSuccess(false);
        response.setCode(SysErrorWarnType.GATEWAY_PARAM_ERROR.getCode().toString());
        response.setMessage(SysErrorWarnType.GATEWAY_PARAM_ERROR.getMsg());
        log.error("Error code is : " + SysErrorWarnType.GATEWAY_PARAM_ERROR.getCode().toString() + ", and error message is : "
                + SysErrorWarnType.GATEWAY_PARAM_ERROR.getMsg());
    }
}
