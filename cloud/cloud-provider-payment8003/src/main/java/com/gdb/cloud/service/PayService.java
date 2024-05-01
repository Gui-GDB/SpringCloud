package com.gdb.cloud.service;

import com.gdb.cloud.pojo.entity.Pay;

import java.util.List;

/**
 * @author Gui
 */
public interface PayService {

    /**
     * 添加支付记录
     * @param pay 支付记录对象
     * @return 返回影响数据库的记录条数
     */
    int add(Pay pay);

    /**
     * 根据主键删除支付记录
     * @param id 支付记录的 id 主键
     * @return 返回删除的记录条数
     */
    int delete(Integer id);

    /**
     * 更新支付记录
     * @param pay 支付记录更新对象
     * @return 返回更新的记录条数
     */
    int update(Pay pay);

    /**
     * 通过 id 主键查询支付记录
     * @param id 主键id
     * @return 返回支付记录对象
     */
    Pay getById(Integer id);

    /**
     * 获取所有的支付记录
     * @return 返回所有的支付记录
     */
    List<Pay> getAll();
}
