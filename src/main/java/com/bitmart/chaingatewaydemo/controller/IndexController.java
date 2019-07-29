package com.bitmart.chaingatewaydemo.controller;

import com.bitmart.chaingatewaydemo.model.index.IndexDTO;
import com.bitmart.chaingatewaydemo.model.index.IndexResponseDTO;
import com.bitmart.chaingatewaydemo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping(value = "/address")
    public IndexResponseDTO indexAddress(IndexDTO indexDTO) {
        return indexService.indexAddressService(indexDTO);
    }

    @GetMapping(value = "/resync/utxo")
    public IndexResponseDTO resyncUtxo(IndexDTO indexDTO) {
        return indexService.resyncUtxoService(indexDTO);
    }

    @GetMapping(value = "/resync/tx")
    public IndexResponseDTO resyncTx(IndexDTO indexDTO) {
        return indexService.resyncTxService(indexDTO);
    }
}
