package the.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//
		http.authorizeHttpRequests()
			.antMatchers("/","/boards/**","/page/**").permitAll()//;//인증필요없이 누구나 접근가능
			.antMatchers("/board/**").hasRole("USER")
			.antMatchers("/admin/**").hasRole("ADMIN")//;
			.anyRequest().authenticated();//나머지주소는 인증을 받아야합니다.
		
		http.formLogin()
			.loginPage("/page/login")
			.loginProcessingUrl("/login")//로그인페이지 의 action
			.usernameParameter("email")//로그인 페이지 username -> email
			.defaultSuccessUrl("/")
			;
		//http.csrf().disable();
	}
	
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//static 디렉토리의 하위파일목록들 인증 무시
		web.ignoring()
			.antMatchers("/css/**");
			//.antMatchers("/js/**")
			//.antMatchers("/images/**");
	}



	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
