package com.gdb.cloud.exception;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-29 02:20
 * @description: id不能为负数异常
 **/

public class IdNegativeNumberException extends RuntimeException{
    public IdNegativeNumberException() {
        super();
    }

    public IdNegativeNumberException(String message) {
        super(message);
    }
}
