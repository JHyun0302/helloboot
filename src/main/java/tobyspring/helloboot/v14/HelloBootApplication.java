package tobyspring.helloboot.v14;

import tobyspring.helloboot.v14.config.MySpringBootApplication;

/**
 * SpringBootApplication
 */

@MySpringBootApplication
public class HelloBootApplication {

	public static void main(String[] args) {
		SpringBootRun.run(HelloBootApplication.class, args);
	}
}
