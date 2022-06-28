package ncstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NcsTest19Application {

	public static void main(String[] args) {
		SpringApplication.run(NcsTest19Application.class, args);
	}

}
