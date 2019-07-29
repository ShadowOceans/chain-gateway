package com.bitmart.chaingatewaydemo.controller;

import com.bitmart.chaingatewaydemo.model.common.CommonDTO;
import com.bitmart.chaingatewaydemo.model.common.CommonResponseDTO;
import com.bitmart.chaingatewaydemo.service.CommonService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/common")
@RestController
public class CommonController {

    @Autowired
    private CommonService commonService;

    @GetMapping("/block/resyncTxid")
    public CommonResponseDTO blockResyncTxid(CommonDTO commonDTO) {
        return commonService.blockResyncTxidService(commonDTO);
    }

    @GetMapping("/block/resyncBlockHeightRange")
    public CommonResponseDTO blockResyncBlockHeightRange(CommonDTO commonDTO) {
        return commonService.blockResyncBlockHeightRangeService(commonDTO);
    }

    @PostMapping("/deposit/depositReview")
    public CommonResponseDTO depositReview(@RequestBody CommonDTO commonDTO) {
        return commonService.depositReviewService(commonDTO);
    }

    @PostMapping("/deposit/reVerify")
    public CommonResponseDTO depositReVerify(@RequestBody CommonDTO commonDTO) {
        return commonService.depositReVerifyService(commonDTO);
    }

    @GetMapping("/withdraw/reVerify")
    public CommonResponseDTO withdrawReVerify(CommonDTO commonDTO) {
        return commonService.withdrawReVerifyService(commonDTO);
    }

    @GetMapping("/sweep/sweepAll")
    public CommonResponseDTO sweepAll(CommonDTO commonDTO) {
        return commonService.sweepAllService(commonDTO);
    }

    @GetMapping("/sweep/sweepFix")
    public CommonResponseDTO sweepFix(CommonDTO commonDTO) {
        return commonService.sweepFixService(commonDTO);
    }

    @GetMapping("/sweep/sweepByUser")
    public CommonResponseDTO sweepByUser(CommonDTO commonDTO) {
        return commonService.sweepByUserService(commonDTO);
    }

    @GetMapping("/sweep/sweepByUserAndToken")
    public CommonResponseDTO sweepByUserAndToken(CommonDTO commonDTO) {
        return commonService.sweepByUserAndTokenService(commonDTO);
    }

    @GetMapping("/sweep/sweepByAddress")
    public CommonResponseDTO sweepByAddress(CommonDTO commonDTO) {
        return commonService.sweepByAddressService(commonDTO);
    }

    @GetMapping("/sweep/sweepByAddressAndToken")
    public CommonResponseDTO sweepByAddressAndToken(CommonDTO commonDTO) {
        return commonService.sweepByAddressAndTokenService(commonDTO);
    }

    @GetMapping("/wallet/checkBalance")
    public CommonResponseDTO wallectCheckBalance(CommonDTO commonDTO) {
        return commonService.wallectCheckBalanceService(commonDTO);
    }

    @GetMapping("/wallet/correctBalance")
    public CommonResponseDTO wallectCorrectBalance(CommonDTO commonDTO) {
        return commonService.wallectCorrectBalanceService(commonDTO);
    }
}
