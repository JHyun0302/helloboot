package tobyspring.helloboot.v17.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import tobyspring.helloboot.v17.config.MyAutoConfiguration;

@MyAutoConfiguration
public class PropertyPlaceholderConfig {
    @Bean PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
