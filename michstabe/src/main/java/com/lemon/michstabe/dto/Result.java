package com.lemon.michstabe.dto;

import com.google.gson.Gson;

public class Result {
    //状态码  300：错误编码  200：正确编码，有数据返回  201：正确编码，无数据返回
    private int code;
    //消息提示
    private String msg;
    //数据
    private Object data;

    // 静态变量Gson，用于格式化JSON
    private static Gson gson = new Gson();

    private Result() {
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 1、错误时返回(code：300  msg：外部传入  data：为空)
    public static String error(String msg) {
        return gson.toJson(new Result(300, msg, null));
    }

    // 2、成功无data返回时(code：201 msg：外部传入 data：为空)
    public static String success(String msg) {
        return gson.toJson(new Result(201, msg, null));
    }

    // 3、成功有data返回时(code：200 msg：外部传入 data：外部传入)
    public static String success(String msg, Object data) {
        return gson.toJson(new Result(200, msg, data));
    }

    // 4、成功且只返回data时(code：200 data：外部传入)
    public static String success(Object data) {
        return gson.toJson(new Result(200, "", data));
    }

    // code msg data 外部传入
    public static String info(int code, String msg, Object data){
        return gson.toJson(new Result(code, msg, data));
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
