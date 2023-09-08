package com.lin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class LinResult implements Serializable {
    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    private Map<String, Object> data = new HashMap<>();

    private LinResult() {
    }

    public static LinResult success() {
        LinResult linResult = new LinResult();
        linResult.code = ResponseStatus.SUCCESS.getCodeName();
        linResult.message = ResponseStatus.SUCCESS.getMessageName();
        return linResult;
    }

    public static LinResult error() {
        LinResult linResult = new LinResult();
        linResult.code = ResponseStatus.FAILURE.getCodeName();
        linResult.message = ResponseStatus.FAILURE.getMessageName();
        return linResult;
    }

    public LinResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public LinResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public LinResult setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public LinResult data(String key, Object data) {
        this.data.put(key, data);
        return this;
    }

    @Override
    public String toString() {
        return "LinResult{" +
               "code=" + code +
               ", message='" + message + '\'' +
               ", data=" + data +
               '}';
    }
}
