package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.good;

@Mapper
public interface GoodMapper extends BaseMapper<good> {
}
