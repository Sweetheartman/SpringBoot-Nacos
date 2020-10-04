package com.senyint.exercise.exception;

import com.senyint.exercise.exception.code.ResponseCodeInterface;

/**
 * @program: springboot-company-frame
 * @description: 运行时主动抛出异常
 * @author: lidekun
 * @create: 2020-08-22 11:46
 **/
public class BusinessException extends RuntimeException{
    /**
     * 提示编码
     */
    private final  int code;

    /**
     * 后端提示语
     */
    private final String msg;

    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(ResponseCodeInterface responseCodeInterface) {
        this(responseCodeInterface.getCode(),responseCodeInterface.getMsg());
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
