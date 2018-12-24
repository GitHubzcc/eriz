package com.eriz.common.util;

/**
 * 消息返回结果集
 *
 * @param <T> class
 *            <p>
 *            2018年12月10日 eriz
 */
public class Result<T> {

    private final static Integer CODE_SUCCESS = 0;
    private final static Integer CODE_FAIL = 1;
    private final static String MSG_SUCCESS = "操作成功";
    private final static String MSG_FAIL = "操作失败";

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回码
     */
    private int code;

    /**
     * 数据
     */
    private T data;

    /**
     * 总条数
     */
    private Integer count;


    /**
     * 构造器
     *
     * @param status 状态
     * @param msg    消息
     * @param data   数据
     */
    public Result(int status, String msg, T data) {
        this.code = status;
        this.message = msg;
        this.data = data;
    }

    public Result(int status, String msg) {
        this.code = status;
        this.message = msg;
    }

    /**
     * 成功返回数据
     *
     * @param data 数据
     */
    public Result(T data) {
        this.data = data;
        this.code = CODE_SUCCESS;
        this.message = MSG_SUCCESS;
    }

    public Result(int status, String msg, Integer total, T data) {
        this.code = status;
        this.message = msg;
        this.count = total;
        this.data = data;
    }

    /**
     * 构建返回结果集
     *
     * @param status 状态码
     * @param msg    消息
     * @param data   数据
     * @param <T>    数据类型
     * @return 结果集
     */
    public static <T> Result<T> build(int status, String msg, T data) {
        return new Result<T>(status, msg, data);
    }

    public static <T> Result<T> build(int status, String msg) {
        return new Result<T>(status, msg);
    }

    public static <T> Result<T> success(int status, String msg, Integer total, T data) {
        return new Result<T>(status, msg, total, data);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> success() {
        return new Result<T>(CODE_SUCCESS, MSG_SUCCESS, null);
    }

    public static <T> Result<T> fail() {
        return new Result<T>(CODE_FAIL, MSG_FAIL, null);
    }

    public static <T> Result<T> getResult(T data) {
        Result<T> result = new Result<>(data);
        return result;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
