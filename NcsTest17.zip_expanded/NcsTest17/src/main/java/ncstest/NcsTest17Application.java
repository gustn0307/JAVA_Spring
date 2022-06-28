package ncstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NcsTest17Application {

	public static void main(String[] args) {
		SpringApplication.run(NcsTest17Application.class, args);
	}

}
