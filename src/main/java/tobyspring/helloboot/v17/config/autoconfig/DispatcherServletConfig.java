package tobyspring.helloboot.v17.config.autoconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import tobyspring.helloboot.v17.config.MyAutoConfiguration;

@MyAutoConfiguration
public class DispatcherServletConfig {
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}
