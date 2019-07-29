package com.bitmart.chaingatewaydemo.controller;

import com.bitmart.chaingatewaydemo.model.blackList.UserBlackListQueryDTO;
import com.bitmart.chaingatewaydemo.model.blackList.UserBlackListResponseDTO;
import com.bitmart.chaingatewaydemo.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/blackList")
@RestController
public class BlackListController {

    @Autowired
    BlackListService blackListService;

    @GetMapping("/blackListConfigQuery")
    public UserBlackListResponseDTO blackListConfigQuery(UserBlackListQueryDTO userBlackListQueryDTO) {
        return blackListService.blackListConfigQuery(userBlackListQueryDTO);
    }

    @PostMapping("/blackListCreate")
    public UserBlackListResponseDTO blackListCreate(@RequestBody UserBlackListQueryDTO userBlackListQueryDTO) {
        return blackListService.blackListCreate(userBlackListQueryDTO);
    }

    @PostMapping("/blackListUpdate")
    public UserBlackListResponseDTO blackListUpdate(@RequestBody UserBlackListQueryDTO userBlackListQueryDTO) {
        return blackListService.blackListUpdate(userBlackListQueryDTO);
    }

}
