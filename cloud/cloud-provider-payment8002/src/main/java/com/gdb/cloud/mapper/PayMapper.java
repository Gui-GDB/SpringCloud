package com.gdb.cloud.mapper;

import com.gdb.cloud.pojo.entity.Pay;

import java.util.List;

public interface PayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pay row);

    int insertSelective(Pay row);

    Pay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pay row);

    int updateByPrimaryKey(Pay row);

    List<Pay> selectAll();
}