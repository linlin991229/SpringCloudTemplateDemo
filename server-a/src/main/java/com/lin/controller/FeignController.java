package com.lin.controller;

import com.lin.LinResult;
import com.lin.feign.LinClient;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("server-a/feign")
public class FeignController {

    @Resource
    private LinClient linClient;

    @GetMapping("{str}")
    public LinResult client(@PathVariable("str") String info) {
        return linClient.echo(info);
    }
}
