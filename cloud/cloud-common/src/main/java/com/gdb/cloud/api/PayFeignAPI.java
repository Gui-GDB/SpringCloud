package com.gdb.cloud.api;

import com.gdb.cloud.pojo.dto.PayDto;
import com.gdb.cloud.pojo.entity.Pay;
import com.gdb.cloud.responseResult.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("cloud-payment-service")
public interface PayFeignAPI {
    @GetMapping(value = "/pay/get/info")
    String getInfoByConsul();

    @PostMapping("/pay/add")
    ResponseResult<String> addPay(@RequestBody Pay pay);

    @DeleteMapping("/pay/del/{id}")
    ResponseResult<Integer> deletePay(@PathVariable("id") Integer id);

    @PutMapping("/pay/update")
    ResponseResult<String> updatePay(@RequestBody PayDto payDto);

    @GetMapping("/pay/get/{id}")
    ResponseResult<Pay> getById(@PathVariable("id") Integer id);

    @GetMapping("/pay/getAll")
    ResponseResult<List<Pay>> getAll();
}
