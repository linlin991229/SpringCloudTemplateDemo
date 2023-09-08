package com.lin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;

@SpringBootTest
public class ServerATest {
    @Test
    void dateTest() {

        for (int i = 0; i < 10; i++) {
            System.out.println(LocalDateTime.now());
            System.out.println(Instant.now());
        }
    }

    @Test
    void ResponseCodeTest(){
        System.out.println(ResponseStatus.SUCCESS.getCodeName() + " " + ResponseStatus.SUCCESS.getMessageName());
        System.out.println(ResponseStatus.FAILURE.getCodeName() + " " + ResponseStatus.FAILURE.getMessageName());
        System.out.println(ResponseStatus.SUCCESS);
    }
}
