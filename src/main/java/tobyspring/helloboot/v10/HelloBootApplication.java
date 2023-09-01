package tobyspring.helloboot.v10;

import tobyspring.helloboot.v10.config.MySpringBootApplication;

/**
 * SpringBootApplication
 */

@MySpringBootApplication
public class HelloBootApplication {

	public static void main(String[] args) {
		SpringBootRun.run(HelloBootApplication.class, args);
	}
}
