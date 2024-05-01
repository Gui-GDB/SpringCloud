package com.gdb.cloud.controller;

import com.gdb.cloud.exception.IdNegativeNumberException;
import com.gdb.cloud.pojo.dto.PayDto;
import com.gdb.cloud.pojo.entity.Pay;
import com.gdb.cloud.responseResult.ResponseResult;
import com.gdb.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-14 15:46
 * @description:
 **/

@Tag(name = "支付微服务模块", description = "支付CRUD")
@Slf4j
@RestController
@RequestMapping("/pay")
public class PayController {
    @Resource
    public PayService payService;
    @Value("${server.port}")
    private String port;

    @Operation(
            summary = "获取端口号和consul配置中心的配置",
            description = "获取配置中心是否生效，获取当前调用的是哪一个服务，验证是否是负载均衡"
    )
    @GetMapping(value = "/get/info")
    private String getInfoByConsul(@Value("${gdb.info}") String info) {
        return "consul info: " + info + ",port: " + port;
    }

    @Operation(
            summary = "新增",
            description = "新增支付流水 API，json串做为参数"
    )
    @PostMapping("/add")
    public ResponseResult<String> addPay(@RequestBody Pay pay) {
        log.info(pay.toString());
        int i = payService.add(pay);
        return ResponseResult.success("成功插入记录，返回值：" + i);
    }

    @Operation(
            summary = "删除",
            description = "删除支付流水 API"
    )
    @DeleteMapping("/del/{id}")
    public ResponseResult<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResponseResult.success(i);
    }

    @Operation(
            summary = "修改",
            description = "修改支付流水 API"
    )
    @PutMapping("/update")
    public ResponseResult<String> updatePay(@RequestBody PayDto payDto) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDto, pay);
        int update = payService.update(pay);
        return ResponseResult.success("成功修改记录，返回值：" + update);
    }

    @Operation(
            summary = "按照 ID 查流水",
            description = "查询支付流水 API"
    )
    @GetMapping("/get/{id}")
    public ResponseResult<Pay> getById(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new IdNegativeNumberException("id不能为负数");
        }
        return ResponseResult.success(payService.getById(id));
    }

    @Operation(
            summary = "查找所有的流水",
            description = "查询所有支付流水的 API"
    )
    @GetMapping("/getAll")
    public ResponseResult<List<Pay>> getAll() {
        return ResponseResult.success(payService.getAll());
    }
}
