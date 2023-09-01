package tobyspring.helloboot.v13;

import tobyspring.helloboot.v13.config.MySpringBootApplication;

/**
 * SpringBootApplication
 */

@MySpringBootApplication
public class HelloBootApplication {

	public static void main(String[] args) {
		SpringBootRun.run(HelloBootApplication.class, args);
	}
}
