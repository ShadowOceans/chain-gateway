package com.bitmart.chaingatewaydemo.service.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bitmart.chain.grpc.dto.backend.GatewayConfigDTO;
import com.bitmart.chaingatewaydemo.enums.InterfaceCodeEnum;
import com.bitmart.chaingatewaydemo.enums.SysErrorWarnType;
import com.bitmart.chaingatewaydemo.model.common.CommonDTO;
import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigQueryDTO;
import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigResponseDTO;
import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigResponseDataDTO;
import com.bitmart.chaingatewaydemo.service.GatewayConfigService;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class RequestHttpService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GatewayConfigService gatewayConfigService;

    /**
     * 通过GET方式与manger进行通信，先通过对backend的访问获取url，对于未获取到的url的时候，进行报错返回。
     */
    public <T> T sent(String interfaceCode, int chainId, String parameters, Class<T> clazz, HttpMethod method, String interfaceType) {
        GatewayConfigQueryDTO gatewayConfigDTO = new GatewayConfigQueryDTO();
        String strbody = "";
        gatewayConfigDTO.setInterfaceCode(InterfaceCodeEnum.getSuffix(interfaceCode));
        gatewayConfigDTO.setChainId(chainId);
        GatewayConfigResponseDTO response = gatewayConfigService.gatewayConfigSingleQuery(gatewayConfigDTO);
        GatewayConfigResponseDataDTO urlDTO = response.getGatewayConfigInfo_();
        if (urlDTO != null && urlDTO.getRequestUrl() != null) {
            String uri = urlDTO.getRequestUrl() + parameters;
            log.info(uri);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            String strbodyTmp = restTemplate.exchange(uri, method, entity, String.class).getBody();
            log.info(strbodyTmp);
            switch (interfaceType){
                case "common": strbody = JSONObject.parseObject(JSONObject.parseObject(strbodyTmp).get("data").toString()).toString();break;
                case "index": strbody = strbodyTmp;break;
                case "utxo": strbody = strbodyTmp;break;
            }
            log.info(strbody);
        } else {
            JSONObject strbodyJson = new JSONObject();
            strbodyJson.put("message", SysErrorWarnType.GATEWAY_URL_RESPPONSE_NULL.getMsg());
            strbodyJson.put("code", SysErrorWarnType.GATEWAY_URL_RESPPONSE_NULL.getCode());
            strbodyJson.put("success", false);
            log.error("Error code is : " + SysErrorWarnType.GATEWAY_URL_RESPPONSE_NULL.getCode().toString() + ", and error message is : "
                    + SysErrorWarnType.GATEWAY_URL_RESPPONSE_NULL.getMsg());
            strbody = strbodyJson.toString();
        }
        return JSONObject.parseObject(strbody, clazz);
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    //通过Post发送请求到服务端获取响应
    public <T> T sentByPost(String interfaceCode, int chainId, CommonDTO commonDTO, Class<T> clazz, String interfaceType) {
        JSONObject result = new JSONObject();
        GatewayConfigQueryDTO gatewayConfigDTO = new GatewayConfigQueryDTO();
        gatewayConfigDTO.setInterfaceCode(InterfaceCodeEnum.getSuffix(interfaceCode));
        gatewayConfigDTO.setChainId(chainId);
        GatewayConfigResponseDTO response = gatewayConfigService.gatewayConfigSingleQuery(gatewayConfigDTO);
        GatewayConfigResponseDataDTO urlDTO = response.getGatewayConfigInfo_();
        if (urlDTO.getRequestUrl() != null) {
            log.info(urlDTO.getRequestUrl());
            String jsonParamBody = JSON.toJSONString(commonDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity entity = new HttpEntity(jsonParamBody, headers);
            JSONObject resultTmp = restTemplate.postForEntity(urlDTO.getRequestUrl(), entity, JSONObject.class).getBody();
            switch (interfaceType){
                case "common": result = JSONObject.parseObject(JSONObject.parseObject(resultTmp.toString()).get("data").toString());break;
                case "index": result = resultTmp;break;
                case "utxo": result = resultTmp;break;
            }
            log.info(result.toString());
        } else {
            result.put("message", SysErrorWarnType.GATEWAY_URL_RESPPONSE_NULL.getMsg());
            result.put("code", SysErrorWarnType.GATEWAY_URL_RESPPONSE_NULL.getCode());
            result.put("success", false);
            if (urlDTO == null)
                log.error("Error code is : " + response.getErrCode_() + ", and error message is : "
                        + response.getErrMsg_());
            else
                log.error("Error code is : " + SysErrorWarnType.GATEWAY_URL_RESPPONSE_NULL.getCode().toString() + ", and error message is : "
                        + SysErrorWarnType.GATEWAY_URL_RESPPONSE_NULL.getMsg());
        }
        return JSONObject.parseObject(result.toString(), clazz);
    }

}
