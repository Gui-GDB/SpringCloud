package com.gdb.cloud.controller;

import com.gdb.cloud.api.PayFeignAPI;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-05-02 13:45
 * @description: 测试OpenFeign的高级特性
 **/
@Slf4j
@RestController
@RequestMapping("/feign/advanced")
public class AdvancedFeignController {
    @Resource
    private PayFeignAPI payFeignAPI;

    @GetMapping("/get/info")
    public String getInfo() {
        String info;
        try {
            log.info("Feign开始调用");
            info = payFeignAPI.getInfoByConsul();
            log.info("Feign调用结束");
        } catch (Exception e) {
            log.info("Feign调用异常");
            e.printStackTrace();
            info = e.getMessage();
        }
        return info;
    }
}
