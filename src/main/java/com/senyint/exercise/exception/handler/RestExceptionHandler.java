package com.senyint.exercise.exception.handler;

import com.senyint.exercise.exception.BusinessException;
import com.senyint.exercise.exception.code.BaseResponseCode;
import com.senyint.exercise.utils.DataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;

/**
 * @ClassName: RestExceptionHandler
 * TODO:类文件简单描述
 * @Author: lidekun
 * @UpdateUser: lidekun
 * @Version: 0.0.1
 */

@RestControllerAdvice // 声明为全局异常类
@Slf4j
public class RestExceptionHandler {

    /**
     * 捕捉系统级别异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public DataResult handleException(Exception e){
        log.error("handleException....{}",e);
        return DataResult.getResult(BaseResponseCode.SYSTEM_ERROR);
    }

    /**
     * 捕捉自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public DataResult handlerBusinessException(BusinessException e){
        log.error("BusinessException ...{}",e);
        return DataResult.getResult(e.getCode(),e.getMsg());
    }

    /**
     * 捕捉参数异常并处理
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DataResult handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        log.error("handlerMethodArgumentNotValidException  AllErrors:{} MethodArgumentNotValidException:{}",e.getBindingResult().getAllErrors(),e);
        String msg=null;
        for(ObjectError error:allErrors){
            msg+=error.getDefaultMessage() + ";";
        }
        return DataResult.getResult(BaseResponseCode.VALIDATOR_ERROR.getCode(),msg);
    }

    /**
     * 捕捉文件上传超出文件限制大小异常
     * @param e
     * @return
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public DataResult maxUploadSizeExceededException(MaxUploadSizeExceededException e){
        log.error("MaxUploadSizeExceededException,{},{}",e,e.getLocalizedMessage());
        return DataResult.getResult(BaseResponseCode.FILE_TOO_LARGE);
    }

}
