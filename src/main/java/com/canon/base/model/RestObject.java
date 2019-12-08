package com.canon.base.model;

import java.io.Serializable;

/**
 * @program: canon-common
 * @Auther: canon
 * @Date: 2019/12/4 16:42
 * @Description:统一返回制式
 */
public class RestObject implements Serializable {

    private static final long serialVersionUID = 3575137913657236639L;

    private static final String OK = "0001";

    private static final String OK_MESSAGE = "ok";

    private static final String WARN = "0002";

    private static final String WARN_MESSAGE = "warn";

    private static final String ERROR = "0003";

    private static final String ERROR_MESSAGE = "error";

    // result code
    private String code;

    // result message
    private String message;

    // result data
    private Object data;


    public RestObject(String code, Object data, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public static RestObject getOk(){
        return new RestObject(OK, null, OK_MESSAGE);
    }

    public static RestObject getOk(String message) {
        return new RestObject(OK ,null, message);
    }

    public static RestObject getOk(Object data,String message) {
        return new RestObject(OK, data, message);
    }

    public static RestObject getOk(Object data) {
        return new RestObject(OK, data, OK_MESSAGE);
    }


    public static RestObject getWarn() {
        return new RestObject(WARN, null, WARN_MESSAGE);
    }

    public static RestObject getWarn(String message) {
        return new RestObject(WARN, null, message);
    }

    public static RestObject getError() {
        return new RestObject(ERROR, null, ERROR_MESSAGE);
    }

    public static RestObject getError(String message) {
        return new RestObject(ERROR, null, message);
    }



    /**
     * 这个先不管
     * @return
     */
    public static RestObject getPageOk() {
        RestObject restObject = getOk();


        return restObject;
    }
}
