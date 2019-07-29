package com.bitmart.chaingatewaydemo.service.grpc;

import com.alibaba.fastjson.JSONObject;
import com.bitmart.chain.grpc.lib.backend.*;
import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigQueryDTO;
import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigResponseDTO;
import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigResponseDataDTO;
import io.grpc.Channel;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class GatewayConfigGrpcService {

    @GrpcClient("grpc-gateway-backend-server")
    protected Channel serverChannel;

    public GatewayConfigResponseDTO gatewayConfigQuery(GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        String correlationID = UUID.randomUUID().toString();
        GatewayConfigResponseDTO gatewayConfigResponseDTO = new GatewayConfigResponseDTO();
        OperChainBackendGrpc.OperChainBackendBlockingStub operChainBackendBlockingStub = OperChainBackendGrpc.newBlockingStub(serverChannel);
        GatewayConfigQryReply res = operChainBackendBlockingStub.withDeadlineAfter(30, TimeUnit.SECONDS).queryGatewayConfig(
                GatewayConfigQryRequest.newBuilder()
                        .setCorrelationID(correlationID)
                        .setInterfaceCode(gatewayConfigQueryDTO.getInterfaceCode() != null ? gatewayConfigQueryDTO.getInterfaceCode() : "")
                        .setPage(gatewayConfigQueryDTO.getPage() != null ? gatewayConfigQueryDTO.getPage() : 0)
                        .setPageSize(gatewayConfigQueryDTO.getPageSize() != null ? gatewayConfigQueryDTO.getPageSize() : 0)
                        .setId(gatewayConfigQueryDTO.getId() != null ? gatewayConfigQueryDTO.getId() : 0)
                        .setChainId(gatewayConfigQueryDTO.getChainId() != null ? gatewayConfigQueryDTO.getChainId() : 0)
                        .setStatus(gatewayConfigQueryDTO.getStatus() != null ? gatewayConfigQueryDTO.getStatus() : "").build());
        gatewayConfigResponseDTO.setGatewayConfigListInfo_(JSONObject.parseObject(res.getGatewayConfigListInfo(), List.class));
        gatewayConfigResponseDTO.setIsSuccess_(res.getIsSuccess());
        gatewayConfigResponseDTO.setErrMsg_(res.getErrMsg());
        gatewayConfigResponseDTO.setErrCode_(res.getErrCode());
        gatewayConfigResponseDTO.setTotalPage_(res.getTotalPage());
        gatewayConfigResponseDTO.setTotalCount_(res.getTotalCount());
        return gatewayConfigResponseDTO;
    }

    public GatewayConfigResponseDTO gatewayConfigSingleQuery(GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        String correlationID = UUID.randomUUID().toString();
        GatewayConfigResponseDTO gatewayConfigResponseDTO = new GatewayConfigResponseDTO();
        OperChainBackendGrpc.OperChainBackendBlockingStub operChainBackendBlockingStub = OperChainBackendGrpc.newBlockingStub(serverChannel);
        GatewayConfigReply res = operChainBackendBlockingStub.withDeadlineAfter(30, TimeUnit.SECONDS).singleQueryGatewayConfig(
                GatewayConfigRequest.newBuilder()
                        .setCorrelationID(correlationID)
                        .setId(gatewayConfigQueryDTO.getId() != null ? gatewayConfigQueryDTO.getId() : 0)
                        .setInterfaceCode(gatewayConfigQueryDTO.getInterfaceCode() != null ? gatewayConfigQueryDTO.getInterfaceCode() : "")
                        .setChainId(gatewayConfigQueryDTO.getChainId() != null ? gatewayConfigQueryDTO.getChainId() : 0)
                        .setChainName(gatewayConfigQueryDTO.getChainName() != null ? gatewayConfigQueryDTO.getChainName() : "")
                        .setRequestUrl(gatewayConfigQueryDTO.getRequestUrl() != null ? gatewayConfigQueryDTO.getChainName() : "")
                        .setDescribe(gatewayConfigQueryDTO.getDescribe() != null ? gatewayConfigQueryDTO.getDescribe() : "")
                        .setOper(gatewayConfigQueryDTO.getOper() != null ? gatewayConfigQueryDTO.getOper() : "")
                        .setStatus(gatewayConfigQueryDTO.getStatus() != null ? gatewayConfigQueryDTO.getStatus() : "").build());
        gatewayConfigResponseDTO.setGatewayConfigInfo_(JSONObject.parseObject(res.getGatewayConfigInfo(), GatewayConfigResponseDataDTO.class));
        gatewayConfigResponseDTO.setIsSuccess_(res.getIsSuccess());
        gatewayConfigResponseDTO.setErrMsg_(res.getErrMsg());
        gatewayConfigResponseDTO.setErrCode_(res.getErrCode());
        return gatewayConfigResponseDTO;
    }

    public GatewayConfigResponseDTO gatewayConfigCreate(GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        String correlationID = UUID.randomUUID().toString();
        GatewayConfigResponseDTO gatewayConfigResponseDTO = new GatewayConfigResponseDTO();
        OperChainBackendGrpc.OperChainBackendBlockingStub operChainBackendBlockingStub = OperChainBackendGrpc.newBlockingStub(serverChannel);
        GatewayConfigReply res = operChainBackendBlockingStub.withDeadlineAfter(30, TimeUnit.SECONDS).gatewayConfigModify(
                GatewayConfigRequest.newBuilder()
                        .setCorrelationID(correlationID)
                        .setId(gatewayConfigQueryDTO.getId() != null ? gatewayConfigQueryDTO.getId() : 0)
                        .setInterfaceCode(gatewayConfigQueryDTO.getInterfaceCode() != null ? gatewayConfigQueryDTO.getInterfaceCode() : "")
                        .setChainId(gatewayConfigQueryDTO.getChainId() != null ? gatewayConfigQueryDTO.getChainId() : 0)
                        .setChainName(gatewayConfigQueryDTO.getChainName() != null ? gatewayConfigQueryDTO.getChainName() : "")
                        .setRequestUrl(gatewayConfigQueryDTO.getRequestUrl() != null ? gatewayConfigQueryDTO.getRequestUrl() : "")
                        .setDescribe(gatewayConfigQueryDTO.getDescribe() != null ? gatewayConfigQueryDTO.getDescribe() : "")
                        .setOper(gatewayConfigQueryDTO.getOper() != null ? gatewayConfigQueryDTO.getOper() : "")
                        .setStatus(gatewayConfigQueryDTO.getStatus() != null ? gatewayConfigQueryDTO.getStatus() : "").build());
        gatewayConfigResponseDTO.setGatewayConfigInfo_(JSONObject.parseObject(res.getGatewayConfigInfo(), GatewayConfigResponseDataDTO.class));
        gatewayConfigResponseDTO.setIsSuccess_(res.getIsSuccess());
        gatewayConfigResponseDTO.setErrMsg_(res.getErrMsg());
        gatewayConfigResponseDTO.setErrCode_(res.getErrCode());
        log.info(gatewayConfigResponseDTO.toString());
        return gatewayConfigResponseDTO;
    }

    public GatewayConfigResponseDTO gatewayConfigUpdate(GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        String correlationID = UUID.randomUUID().toString();
        GatewayConfigResponseDTO gatewayConfigResponseDTO = new GatewayConfigResponseDTO();
        OperChainBackendGrpc.OperChainBackendBlockingStub operChainBackendBlockingStub = OperChainBackendGrpc.newBlockingStub(serverChannel);
        GatewayConfigReply res = operChainBackendBlockingStub.withDeadlineAfter(30, TimeUnit.SECONDS).gatewayConfigModify(
                GatewayConfigRequest.newBuilder()
                        .setCorrelationID(correlationID)
                        .setId(gatewayConfigQueryDTO.getId() != null ? gatewayConfigQueryDTO.getId() : 0)
                        .setInterfaceCode(gatewayConfigQueryDTO.getInterfaceCode() != null ? gatewayConfigQueryDTO.getInterfaceCode() : "")
                        .setChainId(gatewayConfigQueryDTO.getChainId() != null ? gatewayConfigQueryDTO.getChainId() : 0)
                        .setChainName(gatewayConfigQueryDTO.getChainName() != null ? gatewayConfigQueryDTO.getChainName() : "")
                        .setRequestUrl(gatewayConfigQueryDTO.getRequestUrl() != null ? gatewayConfigQueryDTO.getRequestUrl() : "")
                        .setDescribe(gatewayConfigQueryDTO.getDescribe() != null ? gatewayConfigQueryDTO.getDescribe() : "")
                        .setOper(gatewayConfigQueryDTO.getOper() != null ? gatewayConfigQueryDTO.getOper() : "")
                        .setStatus(gatewayConfigQueryDTO.getStatus() != null ? gatewayConfigQueryDTO.getStatus() : "").build());
        gatewayConfigResponseDTO.setGatewayConfigInfo_(JSONObject.parseObject(res.getGatewayConfigInfo(), GatewayConfigResponseDataDTO.class));
        gatewayConfigResponseDTO.setIsSuccess_(res.getIsSuccess());
        gatewayConfigResponseDTO.setErrMsg_(res.getErrMsg());
        gatewayConfigResponseDTO.setErrCode_(res.getErrCode());
        return gatewayConfigResponseDTO;
    }

}