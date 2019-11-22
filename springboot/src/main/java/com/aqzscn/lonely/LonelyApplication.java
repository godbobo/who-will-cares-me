package com.aqzscn.lonely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = {"com.aqzscn.lonely.mapper"})
@SpringBootApplication
public class LonelyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LonelyApplication.class, args);
    }

}
