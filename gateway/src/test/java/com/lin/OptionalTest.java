package com.lin;

import com.alibaba.nacos.common.utils.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class OptionalTest {
    @Test
    void optional() {
        String authorization = null;

        Optional<String> authorizationOptional = Optional.ofNullable(authorization);

        if (authorizationOptional.isPresent()) {
            String token = authorizationOptional.get().split(" ")[1];
            if ("admin".equals(token))
                System.out.println("通过");
        }
        System.out.println("拦截");
    }

    @Test
    void isString() {
        String authorization = "";

        if (StringUtils.isNotBlank(authorization)) {
            String token = authorization.split(" ")[1];
            if ("admin".equals(token))
                System.out.println("通过");
        }
        System.out.println("拦截");
    }
}
