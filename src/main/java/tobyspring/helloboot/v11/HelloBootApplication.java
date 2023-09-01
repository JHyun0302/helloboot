package tobyspring.helloboot.v11;

import tobyspring.helloboot.v11.config.MySpringBootApplication;

/**
 * SpringBootApplication
 */

@MySpringBootApplication
public class HelloBootApplication {

	public static void main(String[] args) {
		SpringBootRun.run(HelloBootApplication.class, args);
	}
}
