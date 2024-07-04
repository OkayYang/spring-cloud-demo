package cn.ywenrou.cloudservice1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.lang.Thread.sleep;

@SpringBootApplication
@EnableEurekaClient
public class CloudService1Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudService1Application.class, args);
    }

}
@RestController
class HelloController {

    @Value("${server.port}")
    private int port;
    @RequestMapping(value = "/service1/hello", method = RequestMethod.GET)
    public String hello() throws UnknownHostException, InterruptedException {
        // 获取当前服务的IP地址
        String ip = InetAddress.getLocalHost().getHostAddress();
        // 将IP地址和端口号组合成返回字符串
        return "Hello Spring Cloud, from IP: " + ip + ", port: " + port;
    }


}
