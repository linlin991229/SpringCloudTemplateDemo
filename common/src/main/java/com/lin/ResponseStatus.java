package com.lin;

public enum ResponseStatus {
    SUCCESS(20000, "操作成功"),
    FAILURE(20001, "操作失败"),

    ITEM("item"),
    LIST("list");

    private int code;
    private String message;

    private String dataName;

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ResponseStatus(String dataName) {
        this.dataName = dataName;
    }

    public int getCodeName() {
        return code;
    }

    public String getMessageName() {
        return message;
    }

    public String getDataName() {
        return dataName;
    }
}
