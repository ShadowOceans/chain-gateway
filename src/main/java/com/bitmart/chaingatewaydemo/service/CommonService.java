package com.bitmart.chaingatewaydemo.service;

import com.bitmart.chaingatewaydemo.enums.InterfaceCodeEnum;
import com.bitmart.chaingatewaydemo.enums.SysErrorWarnType;
import com.bitmart.chaingatewaydemo.model.common.CommonDTO;
import com.bitmart.chaingatewaydemo.model.common.CommonResponseDTO;
import com.bitmart.chaingatewaydemo.service.http.RequestHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommonService {

    @Autowired
    private RequestHttpService requestHttpService;

    @Autowired
    private CheckService checkService;


    public CommonResponseDTO blockResyncTxidService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.stringCheck(commonDTO.getTxid())) {
            response = requestHttpService.sent(InterfaceCodeEnum.BLOCK_RECYNC_TXID.getName(),
                    commonDTO.getChainId(), "/" + commonDTO.getTxid(), CommonResponseDTO.class, HttpMethod.GET,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }


    public CommonResponseDTO blockResyncBlockHeightRangeService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.longCheck(commonDTO.getBeginHeight())
                && checkService.longCheck(commonDTO.getEndHeight()) && commonDTO.getEndHeight() >= commonDTO.getBeginHeight()) {
            response = requestHttpService.sent(InterfaceCodeEnum.BLOCK_RECYNC_BLOCKHEIGHT.getName(),
                    commonDTO.getChainId(), "/" + commonDTO.getBeginHeight() + "/" + commonDTO.getEndHeight(),
                    CommonResponseDTO.class, HttpMethod.GET,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }


    public CommonResponseDTO depositReviewService(CommonDTO commonDTO) {
        log.info(commonDTO.toString());
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.stringCheck(commonDTO.getTxid()) &&
                checkService.longCheck(commonDTO.getUserId()) && checkService.stringCheck(commonDTO.getOper())) {
            response = requestHttpService.sentByPost(InterfaceCodeEnum.DEPOSIT_REVIEW.getName(), commonDTO.getChainId(),
                    commonDTO, CommonResponseDTO.class,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public CommonResponseDTO depositReVerifyService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.stringCheck(commonDTO.getTxid())
        ) {
            response = requestHttpService.sentByPost(InterfaceCodeEnum.DEPOSIT_REVERIFY.getName(), commonDTO.getChainId(), commonDTO, CommonResponseDTO.class,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }


    public CommonResponseDTO withdrawReVerifyService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.longCheck(commonDTO.getRequestId())) {
            System.out.println(commonDTO);
            response = requestHttpService.sent(InterfaceCodeEnum.WITHDRAW_REVERIFY.getName(), commonDTO.getChainId(), "/" + commonDTO.getRequestId(), CommonResponseDTO.class, HttpMethod.GET,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }


    public CommonResponseDTO sweepAllService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId())) {
            response = requestHttpService.sent(InterfaceCodeEnum.SWEEP_ALL.getName(), commonDTO.getChainId(), "", CommonResponseDTO.class, HttpMethod.GET,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public CommonResponseDTO sweepFixService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId())) {
            response = requestHttpService.sent(InterfaceCodeEnum.SWEEP_FIX.getName(), commonDTO.getChainId(), "", CommonResponseDTO.class, HttpMethod.GET,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public CommonResponseDTO sweepByUserService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.longCheck(commonDTO.getUserId())) {
            response = requestHttpService.sent(InterfaceCodeEnum.SWEEP_BY_USER.getName(), commonDTO.getChainId(), "/" + commonDTO.getUserId(), CommonResponseDTO.class, HttpMethod.GET,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public CommonResponseDTO sweepByUserAndTokenService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.longCheck(commonDTO.getUserId()) && checkService.intCheck(commonDTO.getTokenId())) {
            response = requestHttpService.sent(InterfaceCodeEnum.SWEEP_BY_USERANDTOKEN.getName(), commonDTO.getChainId(), "/" + commonDTO.getUserId() + "/" + commonDTO.getTokenId(), CommonResponseDTO.class, HttpMethod.GET,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public CommonResponseDTO sweepByAddressService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.stringCheck(commonDTO.getAddress())) {
            response = requestHttpService.sent(InterfaceCodeEnum.SWEEP_BY_ADDRESS.getName(), commonDTO.getChainId(), "/" + commonDTO.getAddress(), CommonResponseDTO.class, HttpMethod.GET,"common");
            setResponseError(response);
        } else setParamError(response);

        return response;
    }

    public CommonResponseDTO sweepByAddressAndTokenService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.stringCheck(commonDTO.getAddress()) && checkService.intCheck(commonDTO.getTokenId())) {
            response = requestHttpService.sent(InterfaceCodeEnum.SWEEP_BY_ADDRESSANDTOKEN.getName(), commonDTO.getChainId(), "/" + commonDTO.getAddress() + "/" + commonDTO.getTokenId(), CommonResponseDTO.class, HttpMethod.GET,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }


    public CommonResponseDTO wallectCheckBalanceService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.stringCheck(commonDTO.getAddress()) && checkService.intCheck(commonDTO.getTokenId())) {
            response = requestHttpService.sent(InterfaceCodeEnum.WALLET_CHECKBALANCE.getName(), commonDTO.getChainId(), "/" + commonDTO.getAddress() + "/" + commonDTO.getTokenId(), CommonResponseDTO.class, HttpMethod.GET,"common");
            setResponseError(response);
        } else setParamError(response);
        return response;
    }

    public CommonResponseDTO wallectCorrectBalanceService(CommonDTO commonDTO) {
        CommonResponseDTO response = new CommonResponseDTO();
        if (checkService.intCheck(commonDTO.getChainId()) && checkService.intCheck(commonDTO.getTokenId()) &&
                checkService.stringCheck(commonDTO.getAddress()) && commonDTO.getDiffBalance() != null) {
            response = requestHttpService.sent(InterfaceCodeEnum.WALLET_CORRECTBALANCE.getName(),
                    commonDTO.getChainId(), "/" + commonDTO.getAddress() + "/" + commonDTO.getTokenId() + "/" +
                            commonDTO.getDiffBalance(), CommonResponseDTO.class, HttpMethod.GET,"common");
             setResponseError(response);
        } else setParamError(response);
        return response;
    }

    private void setParamError(CommonResponseDTO response) {
        response.setSuccess(false);
        response.setMessage(SysErrorWarnType.GATEWAY_PARAM_ERROR.getMsg());
        response.setCode(SysErrorWarnType.GATEWAY_PARAM_ERROR.getCode().toString());
        log.error("Error code is : " + SysErrorWarnType.GATEWAY_PARAM_ERROR.getCode().toString() + ", and error message is : "
                + SysErrorWarnType.GATEWAY_PARAM_ERROR.getMsg());
    }

    private void setResponseError(CommonResponseDTO response) {
        if (response == null) {
            response.setSuccess(false);
            response.setCode(SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getCode().toString());
            response.setMessage(SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getMsg());
            log.error("Error code is : " + SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getCode().toString() + ", and error message is : "
                    + SysErrorWarnType.GATEWAY_INTERFACE_RESPONSE_NULL_ERROR.getMsg());
        } else if (response.getSuccess() == false)
            log.error("Error code is : " +response.getCode() + ", and error message is : "
                    + response.getMessage());
    }

}
