package tobyspring.helloboot.v9;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tobyspring.helloboot.HelloService;

/**
 * HelloController에 DI 할 때 Decorator를 쓸 지 SimpleHelloService를 쓸 지 모름.
 * - `@Primary` 가 붙은 클래스 먼저 DI함
 */
@Service
@Primary
public class HelloDecorator implements HelloService {
    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) { //SimpleHelloService 주입
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }
}
