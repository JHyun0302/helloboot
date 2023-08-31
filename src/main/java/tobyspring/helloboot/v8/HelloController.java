package tobyspring.helloboot.v8;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tobyspring.helloboot.HelloService;

import java.util.Objects;

/**
 * @Component -> @MyCompoent -> @Controller -> @RestController
 */
@RestController
public class HelloController {
    private final HelloService helloService;
    private final ApplicationContext applicationContext;


    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;

        System.out.println(applicationContext);
    }

    @GetMapping("/hello")
    @ResponseBody
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name)); //name == null 이면 예외 던짐
    }

}
