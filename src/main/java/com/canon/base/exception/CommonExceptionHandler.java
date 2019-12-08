package com.canon.base.exception;

import com.canon.base.model.RestObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 13:47
 * @Description:
 */
@ControllerAdvice
public class CommonExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(CommonExceptionHandler.class);


    @ExceptionHandler(RuntimeException.class)
    public RestObject runtimeExceptionHandler(RuntimeException runtime) {
        return getResult(runtime.getMessage(), runtime);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public RestObject nullPointerExceptionHandler(NullPointerException ex) {
        return getResult("空指针异常", ex);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public RestObject classCastExceptionHandler(ClassCastException ex) {
        return getResult("类型转换异常", ex);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public RestObject iOExceptionHandler(IOException ex) {
        return getResult("IO异常", ex);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public RestObject noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return getResult("未知方法异常", ex);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public RestObject indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return getResult("数组越界异常", ex);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public RestObject requestNotReadable(HttpMessageNotReadableException ex) {
        return getResult("400错误", ex);
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public RestObject requestTypeMismatch(TypeMismatchException ex) {
        return getResult("400错误", ex);
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public RestObject requestMissingServletRequest(MissingServletRequestParameterException ex) {
        return getResult("400错误", ex);
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public RestObject request405(HttpRequestMethodNotSupportedException ex) {
        return getResult("405错误", ex);
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public RestObject request406(HttpMediaTypeNotAcceptableException ex) {
        return getResult("406错误", ex);
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public RestObject server500(RuntimeException ex) {
        return getResult("500错误", ex);
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public RestObject requestStackOverflow(StackOverflowError ex) {
        return getResult("栈溢出", ex);
    }


    private <T extends Throwable> RestObject getResult(String message, T t) {
        log.error(message, t);
        return RestObject.getError(message);
    }

}
