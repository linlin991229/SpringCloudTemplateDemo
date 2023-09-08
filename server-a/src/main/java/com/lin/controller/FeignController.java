package com.lin.controller;

import com.lin.LinResult;
import com.lin.ResponseStatus;
import com.lin.feign.LinClient;
import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("server-a/feign")
public class FeignController {

    @Resource
    private LinClient linClient;

    @Resource
    private WebClient.Builder webClientBuilder;

    @GetMapping("{str}")
    public LinResult client(@PathVariable("str") String info) {
        return linClient.echo(info);
    }

    @GetMapping("webclient/{str}")
    public LinResult webclient(@PathVariable("str") String str) {
        return webClientBuilder.build().get().uri("http://server-b/echo/" + str).retrieve().bodyToMono(LinResult.class)
                .block();
    }

    @Value("pattern.dateformat")
    private String dateformat;

    @GetMapping("readConfig")
    public LinResult getConfig() {
        return LinResult.success().data(ResponseStatus.ITEM.getDataName(), dateformat);
    }
}
