package tobyspring.helloboot.v16.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import tobyspring.helloboot.v16.config.MyAutoConfiguration;

/**
 * PropertyPlaceholderConfig() : `META-INF`의 정보 읽고 자동 구성
 */
@MyAutoConfiguration
public class PropertyPlaceholderConfig {
    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
