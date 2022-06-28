package chojc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NcsTest14Application {

	public static void main(String[] args) {
		SpringApplication.run(NcsTest14Application.class, args);
	}

}
