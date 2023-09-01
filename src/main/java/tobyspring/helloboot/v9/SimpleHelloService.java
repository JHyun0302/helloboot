package tobyspring.helloboot.v9;

import org.springframework.stereotype.Service;
import tobyspring.helloboot.HelloService;

@Service
public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
