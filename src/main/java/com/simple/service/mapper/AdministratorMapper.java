package com.simple.service.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import com.simple.service.bean.Administrator;
import org.springframework.stereotype.Component;

@Component
public interface AdministratorMapper {
    @Select("select * from administrator")
    List<Administrator> getAllAdministrator();
}
