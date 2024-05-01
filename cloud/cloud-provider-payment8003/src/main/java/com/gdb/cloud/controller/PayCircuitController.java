package com.gdb.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-16 19:31
 * @description:
 **/

@RestController
public class PayCircuitController {
    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id) {
        if (id == -4) {
            throw new RuntimeException("------->  id 不能为负数");
        }
        if (id == 9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hello, circuit! inputId: " + id + "\t" + UUID.randomUUID().getLeastSignificantBits();
    }

    @GetMapping("/pay/bulkhead/{id}")
    public String myBulkHead(@PathVariable("id") Integer id) {
        if (id == -4) {
            throw new RuntimeException("-------> bulkhead id 不能为 -4");
        }
        if (id == 9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hello, bulkhead! inputId: " + id + "\t" + UUID.randomUUID().getLeastSignificantBits();
    }

    /**
     * Resilience4j rateLimit 的例子
     * @param id 主键
     * @return 返回结果
     */
    @GetMapping("/pay/rateLimit/{id}")
    public String myRateLimit(@PathVariable("id") Integer id) {
        return "Hello, myRateLimit 欢迎到来 inputId: "+ id + "\t" + UUID.randomUUID();
    }
}
