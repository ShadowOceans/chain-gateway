package com.bitmart.chaingatewaydemo.enums;

import lombok.Getter;
import lombok.Setter;

public enum SysErrorWarnType {
    BACKEND_SUCCESS(0000, "交易成功"),
    BACKEND_FAIL(9999, "系统异常"),


    BACKEND_PARAM_ERROR(9000, "请求参数校验失败："),
    BACKEND_RESULT_EMPTY(9001, "未查询到数据"),

    MANAGER_INVALID_TO_ADDRESS(101, "invalid to address"),
    MANAGER_WITHDRAW_OVER_LIMIT(102, "withdraw over limit"),
    MANAGER_WITHDRAW_AMOUNT_NOT_VALID(103, "invalid to withdraw amount"),
    MANAGER_TX_INVALID_FAIL(104, "tx validate fail: "),
    MANAGER_WITHDRAW_BUILD_OVERTIME(105, "withdraw build overtime"),

    MANAGER_RPC_REQUEST_ERROR(-99, "rpc request error"),
    MANAGER_RPC_NODE_NOT_PREPARED(-98, "rpc node not prepared"),
    MANAGER_LOCAL_SIGN_FAIL(-97, "local sign fail"),
    MANAGER_BALANCE_NOT_ENOUGH(-96, "balance not enough"),
    MANAGER_FEE_BALANCE_NOT_ENOUGH(-95, "fee balance not enough"),
    MANAGER_FEE_RATE_NOT_ENOUGH(-94, "fee rate not enough"),
    MANAGER_TX_REJECTED(-93, "tx rejected"),
    MANAGER_TXID_NOT_SAME(-92, "txid not expected"),
    MANAGER_TX_NOT_FOUND(-91, "tx not found"),
    MANAGER_TX_NOT_CONFIRMED(-90, "tx not confirmed"),


    GATEWAY_PARAM_ERROR(7000, "param is not satisfied"),
    GATEWAY_URL_RESPPONSE_NULL(8000,"NO URL FROM RESPONSE IN DATABASE SATISFAID YOUR OPERATION"),

    GATEWAY_INTERFACE_RESPONSE_NULL_ERROR(9999, "response from interface is null"),

    GATEWAY_DATABASE_RESPONSE_NULL_ERROR(9900, "response from database is null");

    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String msg;

    SysErrorWarnType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
