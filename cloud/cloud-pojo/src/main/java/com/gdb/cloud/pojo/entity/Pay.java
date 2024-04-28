package com.gdb.cloud.pojo.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author Mr.Gui
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pay {
    private Integer id;

    private String payNo;

    private String orderNo;

    private Integer userId;

    private BigDecimal amount;

    private Byte deleted;

    private Date createTime;

    private Date updateTime;
}