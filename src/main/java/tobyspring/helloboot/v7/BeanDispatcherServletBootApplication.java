package tobyspring.helloboot.v7;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Bean 생명주기 메소드
 * TomcatServletWebServerFactory() & DispatcherServlet() : 빈 등록해서 사용하기
 */

@Configuration
@ComponentScan
public class BeanDispatcherServletBootApplication {
	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		return new TomcatServletWebServerFactory();
	}

	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}

	public static void main(String[] args) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				//bean 등록한 TomcatServletWebServerFactory & DispatcherServlet 불러오기
				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//				dispatcherServlet.setApplicationContext(this); //DispatcherServelet에 ApplicationContext 주입

				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet", dispatcherServlet)
							.addMapping("/*");

				}); //톰캣외 다양한 서블릿 기술들 쓸 수 있게 추상화한 결과
				webServer.start(); // 톰캣 서블릿 컨테이너 실행
			}
		};
		applicationContext.register(BeanDispatcherServletBootApplication.class);
		applicationContext.refresh(); //applicationContext가 bean object 생성
	}
}
