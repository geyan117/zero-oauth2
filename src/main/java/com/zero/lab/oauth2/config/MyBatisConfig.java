package com.zero.lab.oauth2.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MapperScan 指定Mapper接口所在的包
 * @author geyan
 * @date 2025/8/24
 */
@Configuration
@MapperScan("com.zero.lab.oauth2.mapper")
public class MyBatisConfig {
}
