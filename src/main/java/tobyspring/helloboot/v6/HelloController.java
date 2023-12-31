package tobyspring.helloboot.v6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tobyspring.helloboot.HelloService;

import java.util.Objects;

/**
 * @Component -> @MyCompoent -> @Controller -> @RestController
 */
@RestController
public class HelloController {
    private final HelloService helloService;


    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name)); //name == null 이면 예외 던짐
    }
}
