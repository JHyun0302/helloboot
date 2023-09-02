package tobyspring.helloboot.v16;

import tobyspring.helloboot.v16.config.MySpringBootApplication;

/**
 * application.properties & 환경 변수
 * 우선 순위 : 환경 변수 > application.properties
 * 기본 설정 : application.properties
 * override 해서 상황에 따라 다른 설정 주고 싶을 때 : 환경 변수 (SystemProperties)
 */

@MySpringBootApplication
public class HelloBootApplication {

//	@Bean
//	ApplicationRunner applicationRunner(Environment env) {
//		return args -> {
//			String name = env.getProperty("my.name");
//			System.out.println("my.name: " + name);
//		};
//	}

	public static void main(String[] args) {
		SpringBootRun.run(HelloBootApplication.class, args);
	}
}
