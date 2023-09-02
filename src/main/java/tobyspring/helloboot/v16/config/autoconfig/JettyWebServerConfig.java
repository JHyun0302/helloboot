package tobyspring.helloboot.v16.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.helloboot.v16.config.ConditionalMyOnClass;
import tobyspring.helloboot.v16.config.MyAutoConfiguration;

/**
 * @ConditionalOnMissingBean : 이미 등록된 빈이면 pass, 등록되지 않은 빈이면 등록
 */
@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    @ConditionalOnMissingBean //개발자가 등록한 빈이라면 pass, 등록되지 않은 bean이면 등록
    public ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }
}
