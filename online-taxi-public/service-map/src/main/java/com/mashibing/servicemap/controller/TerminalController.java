package com.mashibing.servicemap.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.responese.TerminalResponse;
import com.mashibing.servicemap.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/terminal")
public class TerminalController {
    @Autowired
    private TerminalService terminalService;

    @PostMapping("/add")
    public ResponseResult<TerminalResponse> add(@RequestParam String name, @RequestParam String desc) {
        return terminalService.add(name, desc);
    }

    @PostMapping("/aroundsearch")
    public ResponseResult<List<TerminalResponse>> aroundsearch(String center, Integer radius) {

        return terminalService.aroundsearch(center, radius);
    }

    @PostMapping("/trsearch")
    public ResponseResult trsearch(String tid, Long starttime, Long endtime) {

        return terminalService.trsearch(tid, starttime, endtime);
    }

}
