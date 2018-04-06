package com.simple.service.mapper;

import com.simple.service.bean.Goods;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> getAllGoods();
}
