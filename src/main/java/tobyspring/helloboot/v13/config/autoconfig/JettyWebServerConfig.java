package tobyspring.helloboot.v13.config.autoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.helloboot.v13.config.ConditionalMyOnClass;
import tobyspring.helloboot.v13.config.MyAutoConfiguration;

/**
 * tomcat이든 jetty든 외부 라이브러리에 포함되어 있는 servlet 사용함
 */
@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }
}
