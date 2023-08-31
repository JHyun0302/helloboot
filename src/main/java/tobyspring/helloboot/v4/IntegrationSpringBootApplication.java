package tobyspring.helloboot.v4;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 스프링 컨테이너로 통합
 *
 */
public class IntegrationSpringBootApplication {

	public static void main(String[] args) {
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext() {
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
		applicationContext.registerBean(HelloController.class); //bean 등록
		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.refresh(); //applicationContext가 bean object 생성
	}
}
