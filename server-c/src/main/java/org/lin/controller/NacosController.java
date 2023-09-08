package org.lin.controller;

import com.lin.LinResult;
import com.lin.ResponseStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nacos")
@RefreshScope
public class NacosController {
    @Value("${pattern.dateformat}")
    private String dateformat;

    @GetMapping("config")
    public LinResult getInfo() {
        return LinResult.success().data(ResponseStatus.ITEM.getDataName(), dateformat);
    }
}
