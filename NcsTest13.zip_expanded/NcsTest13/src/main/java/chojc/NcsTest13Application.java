package chojc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NcsTest13Application {

	public static void main(String[] args) {
		SpringApplication.run(NcsTest13Application.class, args);
	}

}
