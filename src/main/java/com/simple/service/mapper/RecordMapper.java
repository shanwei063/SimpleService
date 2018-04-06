package com.simple.service.mapper;

import com.simple.service.bean.Record;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecordMapper {
    @Select("select * from record")
    List<Record> getAllRecord();
}
