package tobyspring.helloboot.v16.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.helloboot.v16.config.ConditionalMyOnClass;
import tobyspring.helloboot.v16.config.EnableMyConfigurationProperties;
import tobyspring.helloboot.v16.config.MyAutoConfiguration;

/**
 * @ConditionalOnMissingBean : 이미 등록된 빈이면 pass, 등록되지 않은 빈이면 등록
 */
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {


    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        factory.setContextPath(properties.getContextPath()); // 자동 구성에 의해 만들어지는 빈 object 설정 바꾸기
        factory.setPort(properties.getPort());

        return factory;
    }
}