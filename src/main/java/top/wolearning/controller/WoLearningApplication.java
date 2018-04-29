package top.wolearning.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WoLearningApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        System.out.print("-------------开始启动程序了----------");
        SpringApplication.run(WoLearningApplication.class, args);
        System.out.print("-------------启动成功---------");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WoLearningApplication.class);
    }
}
