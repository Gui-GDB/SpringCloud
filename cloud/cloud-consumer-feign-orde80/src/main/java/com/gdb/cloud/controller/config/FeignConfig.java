package com.gdb.cloud.controller.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-15 14:47
 * @description:
 **/

@Configuration
public class FeignConfig {
    /**
     * 设置 feign 的重试机制
     */
    @Bean
    public Retryer myRetryer() {
        //Feign 默认配置是不走重试策略的
//        return Retryer.NEVER_RETRY;
        //最大请求次数为 3, 初始时间间隔为 100ms，重试最大间隔为 1s.
        return new Retryer.Default(100, 1, 3);
    }

    /**
     * 设置 feign 的日志级别
     */
    @Bean
    public Logger.Level feigenLoggerLevel() {
        return Logger.Level.FULL;
    }
}
