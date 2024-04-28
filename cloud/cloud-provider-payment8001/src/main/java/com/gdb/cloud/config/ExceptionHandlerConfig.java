package com.gdb.cloud.config;


import com.gdb.cloud.exception.IdNegativeNumberException;
import com.gdb.cloud.responseResult.ResponseEnum;
import com.gdb.cloud.responseResult.ResponseResult;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author Mr.Gui
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerConfig {
    /**
     * 空指针异常
     */
    @ExceptionHandler(IdNegativeNumberException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult<String> nullPointException(IdNegativeNumberException e) {
        e.printStackTrace();
        return ResponseResult.error(ResponseEnum.RC400.getResultCode(), e.getMessage());
    }

}
