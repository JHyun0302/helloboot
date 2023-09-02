package tobyspring.helloboot.v17;

import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import tobyspring.helloboot.v17.config.MySpringBootApplication;

import javax.annotation.PostConstruct;

@MySpringBootApplication
public class HellobootApplication {
    private final JdbcTemplate jdbcTemplate;

    public HellobootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }

}
