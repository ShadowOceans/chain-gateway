package com.bitmart.chaingatewaydemo.controller;

import com.bitmart.chaingatewaydemo.model.utxo.UtxoDTO;
import com.bitmart.chaingatewaydemo.model.utxo.UtxoResponseDTO;
import com.bitmart.chaingatewaydemo.service.UtxoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utxo")
public class UtxoController {

    @Autowired
    private UtxoService utxoService;

    @GetMapping(value = "/spent")
    public UtxoResponseDTO utxoSpent(UtxoDTO utxoDTO) {
        return utxoService.utxoSpentService(utxoDTO);
    }

    @GetMapping(value = "/lock")
    public UtxoResponseDTO utxoLock(UtxoDTO utxoDTO) {
        return utxoService.utxoLockService(utxoDTO);
    }

    @GetMapping(value = "/merge")
    public UtxoResponseDTO utxoMerge(UtxoDTO utxoDTO) {
        return utxoService.utxoMergeService(utxoDTO);
    }
}
