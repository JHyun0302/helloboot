package tobyspring.helloboot.v17.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import tobyspring.helloboot.v17.config.ConditionalMyOnClass;
import tobyspring.helloboot.v17.config.EnableMyConfigurationProperties;
import tobyspring.helloboot.v17.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties() operties(ServerProperties.class)
public class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        factory.setContextPath(properties.getContextPath());
        factory.setPort(properties.getPort());

        return factory;
    }


}
