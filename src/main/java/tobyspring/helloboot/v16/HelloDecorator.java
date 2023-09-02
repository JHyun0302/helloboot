package tobyspring.helloboot.v16;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tobyspring.helloboot.HelloService;

@Service
@Primary
public class HelloDecorator implements HelloService {
    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }
}
