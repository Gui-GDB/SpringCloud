package com.gdb.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-14 14:35
 * @description: 启动类
 **/
@SpringBootApplication
@MapperScan("com.gdb.cloud.mapper")
@RefreshScope //启动 consul 全局配置的动态刷新功能
public class Main8003 {
    public static void main(String[] args) {
        SpringApplication.run(Main8003.class, args);
    }
}
