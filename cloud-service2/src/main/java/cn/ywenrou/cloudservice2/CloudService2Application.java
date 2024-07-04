package cn.ywenrou.cloudservice2;
import cn.ywenrou.cloudservice2.service.client.CloudService1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudService2Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudService2Application.class, args);
    }

}

@RestController
class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CloudService1Client service1Client;
    @RequestMapping(value="/service2/hello")
    public String helloController() {
        //return restTemplate.getForObject("http://cloud-service1/service1/hello", String.class);
        return service1Client.hello();

    }



}