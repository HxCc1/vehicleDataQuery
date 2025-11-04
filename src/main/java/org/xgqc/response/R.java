package org.xgqc.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Data
@Accessors(chain = true)
public class R<T> {

    /**
     * 数据
     */
    @ApiModelProperty("数据")
    private T data;

    /**
     * 自定义返回代码。默认200. 区别http通用的代码
     */
    @ApiModelProperty("自定义返回代码。默认200. 区别http通用的代码")
    private int code;

    /**
     *
     */
    private Boolean success;

    /**
     * 返回信息描述，字符最200个
     */
    @ApiModelProperty("返回信息描述")
    private String message;


    //////////////////////////////////////////////////////////////////////////////////
    /*                               静态方法                                */

    /**
     * 成功
     *
     * @return success
     */
    public static <T> R<T> success() {
        R<T> res = new R<>();
        res.setData((T) "");
        res.setSuccess(true);
        return res;
    }

    /**
     * 失败
     *
     * @return fail
     */
    public static <T> R<T> fail(T data) {
        R<T> res = new R<>();
        res.setData(data);
        res.setSuccess(false);
        res.setCode(500);
        return res;
    }

    /**
     * 成功, 并设置数据
     *
     * @param data 数据
     * @return success
     */
    public static <T> R<T> success(T data) {
        R<T> res = new R<>();
        res.setMsg(true, "成功", 200);
        res.setData(data);
        return res;
    }

    /**
     * 成功, 并设置数据, 长度为0的数组
     *
     * @return success
     */
    public static <T> R<T> successArray0() {
        R<T> res = new R<>();
        res.setMsg(true, "", 200);
        res.setData((T) new ArrayList<>(0));
        return res;
    }

    /**
     * 成功, 并设置数据
     *
     * @param data    data
     * @param message message
     * @return success
     */
    public static <T> R<T> success(T data, String message) {
        R<T> res = new R<>();
        res.setMsg(true, message, 200);
        res.setData(data);
        return res;
    }

    /**
     * 失败
     *
     * @return success
     */
    public static <T> R<T> fail(int code, String message) {
        R<T> res = new R<>();
        res.code = code;
        res.data = (T) "";
        res.setMsg(false, message, code);
        return res;
    }

    /**
     * 失败
     *
     * @return success
     */
    public static <T> R<T> fail(T data, String message) {
        R<T> res = new R<>(false, 500);
        res.data = data;
        res.message = message;
        return res;
    }

    /**
     * 失败
     *
     * @return success
     */
    public static <T> R<T> fail(String message) {
        R<T> res = new R<>(false, 500);
        res.setErrMessage(message);
        return res;
    }

    //////////////////////////////////////////////////////////////////////////////////
    /*                               实例方法                                */

    /**
     * 构造函数，设置初始值。默认是返回成功值
     */
    public R() {
        this(true);
    }


    /**
     * 构造函数，设置初始值。默认是返回成功值
     */
    public R(boolean success) {
        this(success, 200);
    }

    /**
     * 构造函数，设置初始值。默认是返回成功值
     */
    public R(boolean success, int code) {
        this.data = (T) "";
        setMsg(success, "", code);
    }


    public R<T> setErrMessage(String message) {
        this.code = 500;
        return setMsg(false, message, 500);
    }

    public R<T> setSuccessMessage(String message) {
        return setMsg(true, message, 200);
    }

    private R<T> setMsg(boolean success, String message, int code) {
        this.success = success;
        this.message = (message == null) ? "" : message;
        if (this.message.length() > 200) {
            this.message = this.message.substring(0, 199);
        }
        this.code = code;
        return this;
    }
}
