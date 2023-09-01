package tobyspring.helloboot.v12.config;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TomcatWebServerConfig 적용
 * DispatcherServletConfig 적용
 * @Configuration(proxyBeanMethods = false) : 프록시 기능을 꺼서 같은 빈 반환 X
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration(proxyBeanMethods = false)
public @interface MyAutoConfiguration {
}
