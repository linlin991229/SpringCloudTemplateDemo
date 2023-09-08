package com.lin.controller.provider;

import com.lin.LinResult;
import com.lin.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("echo")
public class EchoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EchoController.class);

    @GetMapping("{str}")
    public LinResult echo(@PathVariable("str") String str) {
        LOGGER.info("echo str: {}", str);
        return LinResult.success().data(ResponseStatus.ITEM.getDataName(), str);
    }

}
