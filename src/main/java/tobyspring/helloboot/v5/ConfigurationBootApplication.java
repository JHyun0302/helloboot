package tobyspring.helloboot.v5;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import tobyspring.helloboot.HelloController;
import tobyspring.helloboot.HelloService;
import tobyspring.helloboot.SimpleHelloService;

/**
 * 자바 코드 구성정보 사용
 *
 */

@Configuration
public class ConfigurationBootApplication {
	@Bean
	public HelloController helloController(HelloService helloService) {
		return new HelloController(helloService);
	}

	@Bean
	public HelloService helloService() {
		return new SimpleHelloService();
	}

	public static void main(String[] args) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet",
							new DispatcherServlet(this)
					).addMapping("/*");

				}); //톰캣외 다양한 서블릿 기술들 쓸 수 있게 추상화한 결과
				webServer.start(); // 톰캣 서블릿 컨테이너 실행
			}
		};
		applicationContext.register(ConfigurationBootApplication.class);
		applicationContext.refresh(); //applicationContext가 bean object 생성
	}
}
