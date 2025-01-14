package alishev.spring.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestBean {
    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world!";
    }
}
