package cn.ywenrou.cloudservice2.service.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cloud-service1",fallback = CloudService1ClientFallback.class)
public interface CloudService1Client {
    @GetMapping("/service1/hello")
    String hello();
}
@Component
class CloudService1ClientFallback implements CloudService1Client {

    @Override
    public String hello() {
        return "Service 1 is currently unavailable. Please try again later.";
    }
}