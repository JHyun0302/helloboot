package tobyspring.helloboot.v14;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 개발자가 특정 AutoConfiguration 커스텀하기
 */
@Configuration(proxyBeanMethods = false) //프록시를 이용한 같은 빈 생성 X
public class webServerConfiguration {
    @Bean
    ServletWebServerFactory customerWebServerFactory() {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        serverFactory.setPort(9090);
        return serverFactory;
    }
}
