package com.bitmart.chaingatewaydemo.controller;

import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigQueryDTO;
import com.bitmart.chaingatewaydemo.model.gatewayConfig.GatewayConfigResponseDTO;
import com.bitmart.chaingatewaydemo.service.GatewayConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/gatewayConfig")
@RestController
public class GatewayConfigController {

    @Autowired
    private GatewayConfigService gatewayConfigService;

    @GetMapping(value = "/gatewayConfigQuery")
    public GatewayConfigResponseDTO gatewayConfigQuery(GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        return gatewayConfigService.gatewayConfigQuery(gatewayConfigQueryDTO);
    }

    @GetMapping("/gatewayConfigSingleQuery")
    public GatewayConfigResponseDTO gatewayConfigSingleQuery(GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        return gatewayConfigService.gatewayConfigSingleQuery(gatewayConfigQueryDTO);
    }

    @PostMapping("/gatewayConfigCreate")
    public GatewayConfigResponseDTO createGateWayConfigByCodeAndId(@RequestBody GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        return gatewayConfigService.gatewayConfigCreate(gatewayConfigQueryDTO);
    }

    @PostMapping("/gatewayConfigUpdate")
    public GatewayConfigResponseDTO gatewayConfigUpdate(@RequestBody GatewayConfigQueryDTO gatewayConfigQueryDTO) {
        return gatewayConfigService.gatewayConfigUpdate(gatewayConfigQueryDTO);
    }

}
