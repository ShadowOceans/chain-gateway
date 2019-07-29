package com.bitmart.chaingatewaydemo.enums;

import lombok.Getter;
import lombok.Setter;

public enum InterfaceCodeEnum {

    BLOCK_RECYNC_TXID("recyncTxid", "block-resyncTxid"),
    BLOCK_RECYNC_BLOCKHEIGHT("recyncBLockHeight", "block-resyncBlockHeightRange"),

    DEPOSIT_REVIEW("depositReview", "deposit-depositReview"),
    DEPOSIT_REVERIFY("depositReverify", "deposit-reVerify"),

    WITHDRAW_REVERIFY("withdrawReverify", "withdraw-reVerify"),

    SWEEP_ALL("sweepAll", "sweep-sweepAll"),
    SWEEP_BY_ADDRESSANDTOKEN("sweepByAddressAndtoken", "sweep-sweepByAddressAndToken"),
    SWEEP_FIX("sweepFix", "sweep-fix"),
    SWEEP_BY_USER("sweepByUser", "sweep-sweepByUser"),
    SWEEP_BY_USERANDTOKEN("sweepByUserAndToken", "sweep-sweepByUserAndToken"),
    SWEEP_BY_ADDRESS("sweepByAddress", "sweep-sweepByAddress"),

    WALLET_CHECKBALANCE("walletCheckBalance", "wallet-checkBalance"),
    WALLET_CORRECTBALANCE("walletCorrectBalance", "wallet-correctBalance"),

    INDEX_ADDRESSES("indexAddresses", "index-addresses"),
    INDEX_RESYNC_UTXO("indexResyncUtxo", "index-resync-utxo"),
    INDEX_RESYNC_TX("indexResyncTx", "index-resync-tx"),

    UTXO_SPENT("utxoSpent", "utxo-spent"),
    UTXO_LOCK("utxoLock", "utxo-lock"),
    UTXO_MERGE("utxoMerge", "utxo-merge");

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String suffix;

    InterfaceCodeEnum(String name, String suffix) {
        this.name = name;
        this.suffix = suffix;
    }

    public static boolean contain(String name) {
        boolean result = false;
        for (InterfaceCodeEnum e : InterfaceCodeEnum.values())
            if (e.getName().equals(name)) {
                result = true;
                break;
            }
        return result;
    }

    public static String getSuffix(String name) {
        String result = "";
        for (InterfaceCodeEnum e : InterfaceCodeEnum.values())
            if (e.getName().equals(name)) {
                result = e.getSuffix();
                break;
            }
        return result;
    }
}
