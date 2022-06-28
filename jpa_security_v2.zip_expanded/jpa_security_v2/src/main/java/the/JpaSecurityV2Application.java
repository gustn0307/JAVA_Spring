package the;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpaSecurityV2Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaSecurityV2Application.class, args);
	}

}
