package com.gxk.dataway;
import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableHasor()    // 在Spring 中启用 Hasor
@EnableHasorWeb() // 将 hasor-web 配置到 Spring 环境中，Dataway 的 UI 是通过 hasor-web 提供服务。
@SpringBootApplication
@MapperScan(value = "com.gxk.dataway.mapper")
public class DatawayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatawayApplication.class, args);
    }
}
