package tobyspring.helloboot.v11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tobyspring.helloboot.HelloService;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) { //@Primary 붙은 클래스 먼저 주입 (HelloDecorator)
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        return helloService.sayHello(name);
//        return helloService.sayHello(Objects.requireNonNull(name)); //name == null 이면 예외 던짐
    }

}
