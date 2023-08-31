package tobyspring.helloboot.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tobyspring.helloboot.HelloService;

import java.util.Objects;

/**
 * Dependency Injection
 */
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name)); //name == null 이면 예외 던짐
    }
}
