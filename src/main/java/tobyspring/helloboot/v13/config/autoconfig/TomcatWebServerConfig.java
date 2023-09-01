package tobyspring.helloboot.v13.config.autoconfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.helloboot.v13.config.ConditionalMyOnClass;
import tobyspring.helloboot.v13.config.MyAutoConfiguration;

/**
 * tomcat이든 jetty든 외부 라이브러리에 포함되어 있는 servlet 사용함
 */
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}
