package com.gdb.cloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-payment-service", contextId = "circuit")
public interface PayCircuitFeignAPI {
    @GetMapping("/pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);
}
