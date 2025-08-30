package com.zero.lab.oauth2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author geyan
 * @date 2025/8/30
 */
@Configuration
@Slf4j
public class JacksonConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        log.info(">>> 正在创建自定义的 ObjectMapper，注册 JavaTimeModule...");
        ObjectMapper mapper = new ObjectMapper();
        // 明确注册 JavaTimeModule
        mapper.registerModule(new JavaTimeModule());

        // 禁用将日期写成时间戳（否则 LocalDateTime 会变成数字）
        mapper.disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper;
    }
}
