package com.simplework.simplework.Utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Result implements Serializable {

    private boolean success;

    private int code;

    private String msg;

    private Map<String,Object> data = new HashMap<>();

    private long timestamp;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    private Result(){
        timestamp = System.currentTimeMillis();
    }

    public static Result ok(){
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMsg("成功");
        return r;
    }

    public static Result error(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMsg("失败");
        return r;
    }

    public static Result paserror(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMsg("密码错误");
        return r;
    }

    public static Result usererror(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMsg("用户不存在");
        return r;
    }

    public Result data(String key,Object value) {
        this.data.put(key,value);
        return this;
    }
}
