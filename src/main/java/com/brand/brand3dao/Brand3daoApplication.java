package com.brand.brand3dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.brand.brand3dao.dal.mapper"})
public class Brand3daoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Brand3daoApplication.class, args);
    }

}
