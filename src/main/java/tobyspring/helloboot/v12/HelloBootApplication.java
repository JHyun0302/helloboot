package tobyspring.helloboot.v12;

import tobyspring.helloboot.v12.config.MySpringBootApplication;

/**
 * SpringBootApplication
 */

@MySpringBootApplication
public class HelloBootApplication {

	public static void main(String[] args) {
		SpringBootRun.run(HelloBootApplication.class, args);
	}
}
