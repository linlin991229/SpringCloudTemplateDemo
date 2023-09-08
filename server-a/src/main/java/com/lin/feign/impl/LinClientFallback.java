package com.lin.feign.impl;


import com.lin.LinResult;
import com.lin.feign.LinClient;

public class LinClientFallback implements LinClient {

    @Override
    public LinResult echo(String str) {
        return LinResult.error().setMessage("echo fallback");
    }
}
