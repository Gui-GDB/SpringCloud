package com.gdb.cloud.controller;

import com.gdb.cloud.pojo.dto.PayDto;
import com.gdb.cloud.pojo.entity.Pay;
import com.gdb.cloud.responseResult.ResponseEnum;
import com.gdb.cloud.responseResult.ResponseResult;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-14 17:49
 * @description: 订单相关的接口
 **/

@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {
    /**
     * 这里采用的是硬编码的地址，可扩展性低下
     */
    public static final String PAYMENT_SERVICE_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;


//    @GetMapping("/pay/get/port")
//    public ResponseResult getPayPort(){
//        return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/pay/get/port", ResponseResult.class);
//    }

    @PostMapping("/pay/add")
    public ResponseResult<String> addOrder(@RequestBody Pay pay) {
        return restTemplate.postForObject(PAYMENT_SERVICE_URL + "/pay/add", pay, ResponseResult.class);
    }

    //todo 这里调用 Pay 模块的接口，传递的参数为负数，返回的状态码是 500，直接就返回错误信息了，如何处理。
    @GetMapping("/pay/get/{id}")
    public ResponseResult<Pay> getOrder(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/pay/get/" + id, ResponseResult.class);
    }

    @DeleteMapping("/pay/del/{id}")
    public ResponseResult delOrder(@PathVariable("id") Integer id) {
        return restTemplate.exchange(PAYMENT_SERVICE_URL + "/pay/del/" + id, HttpMethod.DELETE, null, ResponseResult.class).getBody();
    }

    @PutMapping("/pay/update")
    public ResponseResult updateOrder(@RequestBody PayDto payDto) {
        return restTemplate.exchange(PAYMENT_SERVICE_URL + "/pay/update", HttpMethod.PUT, new HttpEntity<>(payDto), ResponseResult.class).getBody();
    }

    @GetMapping("/pay/getAll")
    public ResponseResult getAllOrder() {
        return restTemplate.getForObject(PAYMENT_SERVICE_URL + "/pay/getAll", ResponseResult.class);
    }
}
