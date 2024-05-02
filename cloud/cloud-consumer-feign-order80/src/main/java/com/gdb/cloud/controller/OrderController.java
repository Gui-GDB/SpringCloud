package com.gdb.cloud.controller;

import com.gdb.cloud.api.PayFeignAPI;
import com.gdb.cloud.pojo.dto.PayDto;
import com.gdb.cloud.pojo.entity.Pay;
import com.gdb.cloud.responseResult.ResponseResult;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-14 17:49
 * @description: 订单相关的接口
 **/

@Slf4j
@RestController
@RequestMapping("/feign")
public class OrderController {
    @Resource
    private PayFeignAPI payFeignAPI;

    @GetMapping("/pay/get/info")
    public String getPort() {
        return payFeignAPI.getInfoByConsul();
    }

    @PostMapping("/pay/add")
    public ResponseResult<String> addOrder(@RequestBody Pay pay) {
        return payFeignAPI.addPay(pay);
    }

    //todo 这里调用 Pay 模块的接口，传递的参数为负数，返回的状态码是 500，直接就返回错误信息了，如何处理。
    @GetMapping("/pay/get/{id}")
    public ResponseResult<Pay> getOrder(@PathVariable("id") Integer id) {
        return payFeignAPI.getById(id);
    }

    @DeleteMapping("/pay/del/{id}")
    public ResponseResult delOrder(@PathVariable("id") Integer id) {
        return payFeignAPI.deletePay(id);
    }

    @PutMapping("/pay/update")
    public ResponseResult updateOrder(@RequestBody PayDto payDto) {
        return payFeignAPI.updatePay(payDto);
    }

    @GetMapping("/pay/getAll")
    public ResponseResult getAllOrder() {
        return payFeignAPI.getAll();
    }
}
