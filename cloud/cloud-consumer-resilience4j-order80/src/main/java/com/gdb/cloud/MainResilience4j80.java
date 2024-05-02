package com.gdb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-14 17:37
 * @description:
 **/

@SpringBootApplication
@EnableFeignClients
public class MainResilience4j80 {
    public static void main(String[] args) {
        SpringApplication.run(MainResilience4j80.class, args);
    }
}
