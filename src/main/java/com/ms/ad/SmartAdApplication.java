package com.ms.ad;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("com.ms.ad.mapper") // 确保这里的包路径正确
public class SmartAdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartAdApplication.class, args);
        // 打印Swagger文档的访问链接
        log.info("访问Swagger文档请前往: http://localhost:8080/swagger-ui/index.html");
    }

}
