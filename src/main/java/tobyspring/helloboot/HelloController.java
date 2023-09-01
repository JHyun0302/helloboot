package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Dependency Injection
 */
@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping()
    @ResponseBody
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        return helloService.sayHello(name);
//        return helloService.sayHello(Objects.requireNonNull(name)); //name == null 이면 예외 던짐
    }
}
