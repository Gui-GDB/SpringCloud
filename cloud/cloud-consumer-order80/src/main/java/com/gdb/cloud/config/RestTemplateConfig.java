package com.gdb.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-14 17:45
 * @description:
 **/

@Configuration
public class RestTemplateConfig {
    /**
     * 使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡的能力
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
