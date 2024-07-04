package cn.ywenrou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy // 启用Zuul代理
@SpringBootApplication
public class CloudZuul80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuul80Application.class, args);
    }

}
