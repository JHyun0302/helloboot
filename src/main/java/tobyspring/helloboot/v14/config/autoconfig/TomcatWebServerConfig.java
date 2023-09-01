package tobyspring.helloboot.v14.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.helloboot.v14.config.ConditionalMyOnClass;
import tobyspring.helloboot.v14.config.MyAutoConfiguration;

/**
 * @ConditionalOnMissingBean : 이미 등록된 빈이면 pass, 등록되지 않은 빈이면 등록
 */
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}