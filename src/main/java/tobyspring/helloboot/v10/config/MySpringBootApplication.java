package tobyspring.helloboot.v10.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration //메타 애노테이션
@ComponentScan //메타 애노테이션
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {

}
