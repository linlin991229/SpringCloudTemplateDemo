package com.lin.feign;

import com.lin.LinResult;
import com.lin.feign.impl.LinClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "server-b", contextId = "server-b", fallback = LinClientFallback.class)
public interface LinClient {
    @GetMapping("/echo/{str}")
    LinResult echo(@PathVariable("str") String str);

}
