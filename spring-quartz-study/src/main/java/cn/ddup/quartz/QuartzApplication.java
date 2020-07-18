package cn.ddup.quartz;
/**
 * 建module
 * 改pom
 * 写yml
 * 主启动
 * 业务类
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ddup.springcloud.entities","cn.ddup.quartz"})
public class QuartzApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class,args);
    }
}
