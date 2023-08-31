package tobyspring.helloboot.v2;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring Container 생성
 * - 비지니스 로직 등을 빈으로 등록하는 역할
 * - Spring Container == DI Container
 * -- 동적 의존관계 가지는 것을 도와주는 역할 (= Assembler)
 * 1. HelloController 사용 시 HelloService 있어야 함
 * 2. Spring은 Container를 뒤지면서 HelloService를 찾음
 * 3. HelloService의 구현체인 SimpleHelloService 찾아서 주입
 */
public class SpringContainerBootApplication {

	public static void main(String[] args) {
		GenericApplicationContext applicationContext = new GenericApplicationContext(); //Spring Container
		applicationContext.registerBean(HelloController.class); //bean 등록
		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.refresh(); //applicationContext가 bean object 생성

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory(); //톰캣 서버를 만드는 복잡한 설정을 간단하게 제공
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					// 인증 보안, 다국어 공통 기능
					if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
						String name = req.getParameter("name");

						HelloController helloController = applicationContext.getBean(HelloController.class);//bean object 호출
						String ret = helloController.hello(name);

//						resp.setStatus(HttpStatus.OK.value()); // Servlet Container가 묵시적으로 OK status 설정함
//						resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE); // .setContentType() 쓰면 파라미터 1개만 가능
						resp.setContentType( MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(ret);
					} else {
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*");

		}); //톰캣외 다양한 서블릿 기술들 쓸 수 있게 추상화한 결과
		webServer.start(); // 톰캣 서블릿 컨테이너 실행

	}

}
