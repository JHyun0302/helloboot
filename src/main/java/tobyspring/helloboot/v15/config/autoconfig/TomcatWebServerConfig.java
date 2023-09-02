package tobyspring.helloboot.v15.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import tobyspring.helloboot.v15.config.ConditionalMyOnClass;
import tobyspring.helloboot.v15.config.MyAutoConfiguration;

/**
 * @ConditionalOnMissingBean : 이미 등록된 빈이면 pass, 등록되지 않은 빈이면 등록
 */
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(Environment env) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setContextPath(env.getProperty("contextPath")); // 자동 구성에 의해 만들어지는 빈 object 설정 바꾸기
        return factory;
    }
}