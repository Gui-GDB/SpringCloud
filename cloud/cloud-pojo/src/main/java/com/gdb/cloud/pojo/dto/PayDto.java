package com.gdb.cloud.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-14 15:48
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "前端传递的参数")
public class PayDto {
    @Schema(description = "主键值")
    private Integer id;
    @Schema(description = "支付流水号")
    private String payNo;
    @Schema(description = "订单流水号")
    private String orderNo;
    @Schema(description = "用户账号 ID")
    private Integer userId;
    @Schema(description = "交易金额")
    private BigDecimal amount;
}
