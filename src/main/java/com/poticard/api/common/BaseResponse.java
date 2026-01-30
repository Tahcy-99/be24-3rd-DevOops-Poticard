package com.poticard.api.common;

/*
*   {success: true, code: 1000, message: '아이디 비밀번호를 확인해주세요', result: 실제 응답 객체}
*
 */
public class BaseResponse<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private T result;

    public BaseResponse(Boolean success, Integer code, String message, T result) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static <T> BaseResponse success(T result) {
        return new BaseResponse(true, 20000, "success", result);
    }

    public static <T> BaseResponse fail(T result) {
        return new BaseResponse(false, 40000, "실패", result);
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
