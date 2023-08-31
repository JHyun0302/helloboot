package tobyspring.helloboot.v3;

import tobyspring.helloboot.HelloService;

public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
