package tobyspring.helloboot.v6;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //애노테이션이 어디까지 살아있을 것인가.. life cycle
@Target(ElementType.TYPE) //class or interface 위의 타입에 붙는 애노테이션
@Component
public @interface MyComponent {
}
