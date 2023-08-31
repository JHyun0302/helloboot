package tobyspring.helloboot;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 직접 서블릿 컨테이너 띄우고 서블릿까지 등록해서 동작
 */
public class HellobootApplication {

	public static void main(String[] args) {
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory(); //톰캣 서버를 만드는 복잡한 설정을 간단하게 제공
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					String name = req.getParameter("name");

//					resp.setStatus(200);
					resp.setStatus(HttpStatus.OK.value());
//					resp.setHeader("Content-Type", "text/plain");
					resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
					resp.getWriter().println("Hello " + name);
				}
			}).addMapping("/hello");

		}); //톰캣외 다양한 서블릿 기술들 쓸 수 있게 추상화한 결과
		webServer.start(); // 톰캣 서블릿 컨테이너 실행

	}

}
