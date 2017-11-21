package com.hanxx.springboot.vo;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 16:57 2017/11/7
 * @Description: <p>
 * <p> 自定义响应的对象
 */

public class Response {

    //是否成功
    private boolean success;

    //响应消息
    private String message;

    //响应的数据
    private Object body;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, String message, Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }
}


