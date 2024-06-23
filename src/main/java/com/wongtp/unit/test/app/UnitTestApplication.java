/*
 * Copyleft
 */
package com.wongtp.unit.test.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wongtp
 * @date 2024-06-19
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan
public class UnitTestApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UnitTestApplication.class).run(args);
    }
}
