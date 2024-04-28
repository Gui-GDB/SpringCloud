package com.gdb.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-14 14:35
 * @description: 启动类
 **/
@SpringBootApplication
@MapperScan("com.gdb.cloud.mapper")

public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}
