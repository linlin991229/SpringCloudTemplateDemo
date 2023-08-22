package com.lin.controller.provider;

import com.lin.LinResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("echo")
public class EchoController {
    @GetMapping("{str}")
    public LinResult echo(@PathVariable("str") String str) {
        return new LinResult().success().data(str);
    }

}
