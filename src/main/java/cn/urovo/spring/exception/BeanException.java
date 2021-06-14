package cn.urovo.spring.exception;

import cn.urovo.spring.global.BaseMessageConf;
import cn.urovo.spring.global.ErrorCode;

import java.io.Serializable;

/**
 * @author: zWX1038562
 * @create: 2021-06-13 15:18
 **/
public class BeanException extends RuntimeException implements Serializable {

    private String code;

    public BeanException() {
        super(BaseMessageConf.OPERATION_FAILED);
        this.code = ErrorCode.DEFAULT_ERROR;
    }

    public BeanException(String message) {
        super(message);
        this.code = ErrorCode.BEANDEFINITION_NOT_EXITED_ERROR;
    }

}
