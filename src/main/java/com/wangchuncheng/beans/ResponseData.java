package com.wangchuncheng.beans;

/**
 * Created by Wangchuncheng on 2018/7/30 11:04
 */
public class ResponseData {
    public static final String STATUS_ERROR = "error";
    public static final String STATUS_SUCCESS = "success";

    private String status;
    private String message;
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
