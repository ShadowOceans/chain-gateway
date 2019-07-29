package com.bitmart.chaingatewaydemo.service.grpc;

import com.alibaba.fastjson.JSONObject;
import com.bitmart.chain.grpc.lib.backend.*;
import com.bitmart.chaingatewaydemo.model.blackList.UserBlackListQueryDTO;
import com.bitmart.chaingatewaydemo.model.blackList.UserBlackListResponseDTO;
import com.bitmart.chaingatewaydemo.model.blackList.UserBlackListResponseDataDTO;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class BlackListGrpcService {

    @GrpcClient("grpc-gateway-backend-server")
    protected Channel serverChannel;

    public UserBlackListResponseDTO gatewayConfigQuery(UserBlackListQueryDTO userBlackListQueryDTO) {
        UserBlackListResponseDTO response = new UserBlackListResponseDTO();
        String correlationID = UUID.randomUUID().toString();
        OperChainBackendGrpc.OperChainBackendBlockingStub operChainBackendBlockingStub = OperChainBackendGrpc.newBlockingStub(serverChannel);
        UserBlackListQryReply res = operChainBackendBlockingStub.withDeadlineAfter(30, TimeUnit.SECONDS).queryUserBlackList(
                UserBlackListQryRequest.newBuilder()
                        .setCorrelationID(correlationID)
                        .setBlackName(userBlackListQueryDTO.getBlackName() != null ? userBlackListQueryDTO.getBlackName() : "")
                        .setPage(userBlackListQueryDTO.getPage() != null ? userBlackListQueryDTO.getPage() : 0)
                        .setPageSize(userBlackListQueryDTO.getPageSize() != null ? userBlackListQueryDTO.getPageSize() : 0)
                        .setId(userBlackListQueryDTO.getId() != null ? userBlackListQueryDTO.getId() : 0)
                        .setBlackType(userBlackListQueryDTO.getBlackType() != null ? userBlackListQueryDTO.getBlackType() : 0)
                        .setDeleted(userBlackListQueryDTO.getDeleted() != null ? userBlackListQueryDTO.getDeleted().toString() : "").build());
        response.setUserBlackListInfo_(JSONObject.parseObject(res.getUserBlackListInfo(), List.class));
        response.setIsSuccess_(res.getIsSuccess());
        response.setErrMsg_(res.getErrMsg());
        response.setErrCode_(res.getErrCode());
        response.setTotalPage_(res.getTotalPage());
        response.setTotalCount_(res.getTotalCount());
        return response;
    }

    public UserBlackListResponseDTO blackListCreate(UserBlackListQueryDTO userBlackListQueryDTO) {
        UserBlackListResponseDTO response = new UserBlackListResponseDTO();
        String correlationID = UUID.randomUUID().toString();
        OperChainBackendGrpc.OperChainBackendBlockingStub operChainBackendBlockingStub = OperChainBackendGrpc.newBlockingStub(serverChannel);
        UserBlackListReply res = operChainBackendBlockingStub.withDeadlineAfter(30, TimeUnit.SECONDS).userBlackListModify(
                UserBlackListRequest.newBuilder()
                        .setCorrelationID(correlationID)
                        .setBlackName(userBlackListQueryDTO.getBlackName() != null ? userBlackListQueryDTO.getBlackName() : "")
                        .setId(userBlackListQueryDTO.getId() != null ? userBlackListQueryDTO.getId() : 0)
                        .setBlackType(userBlackListQueryDTO.getBlackType() != null ? userBlackListQueryDTO.getBlackType() : 0)
                        .setDescribe(userBlackListQueryDTO.getDescribe() != null ? userBlackListQueryDTO.getDescribe() : "")
                        .setOper(userBlackListQueryDTO.getOper() != null ? userBlackListQueryDTO.getOper() : "")
                        .setDeleted(userBlackListQueryDTO.getDeleted() != null ? userBlackListQueryDTO.getDeleted().toString() : "").build());
        response.setUserBlackInfo(JSONObject.parseObject(res.getUserBlackInfo(), UserBlackListResponseDataDTO.class));
        response.setIsSuccess_(res.getIsSuccess());
        response.setErrMsg_(res.getErrMsg());
        response.setErrCode_(res.getErrCode());
        return response;
    }

    public UserBlackListResponseDTO blackListUpdate(UserBlackListQueryDTO userBlackListQueryDTO) {
        UserBlackListResponseDTO response = new UserBlackListResponseDTO();
        String correlationID = UUID.randomUUID().toString();
        OperChainBackendGrpc.OperChainBackendBlockingStub operChainBackendBlockingStub = OperChainBackendGrpc.newBlockingStub(serverChannel);
        UserBlackListReply res = operChainBackendBlockingStub.withDeadlineAfter(30, TimeUnit.SECONDS).userBlackListModify(
                UserBlackListRequest.newBuilder()
                        .setCorrelationID(correlationID)
                        .setBlackName(userBlackListQueryDTO.getBlackName() != null ? userBlackListQueryDTO.getBlackName() : "")
                        .setId(userBlackListQueryDTO.getId() != null ? userBlackListQueryDTO.getId() : 0)
                        .setBlackType(userBlackListQueryDTO.getBlackType() != null ? userBlackListQueryDTO.getBlackType() : 0)
                        .setDescribe(userBlackListQueryDTO.getDescribe() != null ? userBlackListQueryDTO.getDescribe() : "")
                        .setOper(userBlackListQueryDTO.getOper() != null ? userBlackListQueryDTO.getOper() : "")
                        .setDeleted(userBlackListQueryDTO.getDeleted() != null ? userBlackListQueryDTO.getDeleted().toString() : "").build());
        response.setUserBlackInfo(JSONObject.parseObject(res.getUserBlackInfo(), UserBlackListResponseDataDTO.class));
        response.setIsSuccess_(res.getIsSuccess());
        response.setErrMsg_(res.getErrMsg());
        response.setErrCode_(res.getErrCode());
        return response;
    }
}
