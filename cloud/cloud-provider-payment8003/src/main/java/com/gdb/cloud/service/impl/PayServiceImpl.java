package com.gdb.cloud.service.impl;

import com.gdb.cloud.mapper.PayMapper;
import com.gdb.cloud.pojo.entity.Pay;
import com.gdb.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Mr.Gui
 * @program: cloud
 * @create: 2024-04-14 15:25
 * @description: 支付相关的服务
 **/

@Service
public class PayServiceImpl implements PayService {
    @Resource
    public PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
