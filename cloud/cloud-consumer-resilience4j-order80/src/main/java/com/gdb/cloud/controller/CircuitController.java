package com.gdb.cloud.controller;

import com.gdb.cloud.api.PayCircuitFeignAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-05-02 19:21
 * @description: Circuit的order测试控制器
 **/

@RestController
@RequestMapping("/circuit")
public class CircuitController {
    @Resource
    private PayCircuitFeignAPI payCircuitFeignAPI;

    @GetMapping("/order/{id}")
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myCircuitFallback")
    public String myCircuit(@PathVariable("id") Integer id) {
        return payCircuitFeignAPI.myCircuit(id);
    }

    /**
     * myCircuitFallback就是服务降级后的兜底处理方法
     */
    public String myCircuitFallback(Integer id, Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }
}
