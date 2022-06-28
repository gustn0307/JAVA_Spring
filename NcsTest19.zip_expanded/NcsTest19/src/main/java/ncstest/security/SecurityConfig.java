package ncstest.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
			.antMatchers("/", "/sign/**").permitAll()//인증필요없이 누구나 접근가능
			.anyRequest().authenticated();//나머지주소는 인증을 받아야합니다.
		
		http.formLogin() // /login
			.loginPage("/sign/signin")
			.loginProcessingUrl("/sign/signin")//로그인페이지 의 action
			.usernameParameter("email")//로그인 페이지 username -> email
			.defaultSuccessUrl("/")
			;
		http.csrf().disable();
	}
	

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("favicon.ico*")
		.antMatchers("/images/**")
		.antMatchers("/css/**");
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
/*
	@Bean(name = "transactionManager")
	public PlatformTransactionManager dataPlatformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	//*/
}
