package tobyspring.helloboot.v8;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringBootRun {
    public static void run(Class<?> applicationClass,String... args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                //bean 등록한 TomcatServletWebServerFactory & DispatcherServlet 불러오기
                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);

                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                            .addMapping("/*");

                }); //톰캣외 다양한 서블릿 기술들 쓸 수 있게 추상화한 결과
                webServer.start(); // 톰캣 서블릿 컨테이너 실행
            }
        };
        applicationContext.register(applicationClass);
        applicationContext.refresh(); //applicationContext가 bean object 생성
    }
}
