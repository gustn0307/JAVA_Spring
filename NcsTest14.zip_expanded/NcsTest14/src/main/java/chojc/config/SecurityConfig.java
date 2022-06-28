package chojc.config;

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
			.antMatchers("/", "/log/page").permitAll()//인증필요없이 누구나 접근가능
			.antMatchers("/member/**").hasRole("USER")
			.antMatchers("/admin/**").permitAll()
			.anyRequest().authenticated();//나머지주소는 인증을 받아야합니다.
		
		http.formLogin() // /login
			.loginPage("/log/page")
			.loginProcessingUrl("/login/proc")//로그인페이지 의 action
			.usernameParameter("email")//로그인 페이지 username -> email
			.defaultSuccessUrl("/")
			;
		//인증을위한 AuthenticationManager 인증처리를 한다.
		//실제처리시 UsernamePasswordAuthenticationToken 토큰이라는 이름으로 전달
		//UsernamePasswordAuthenticationFilter 내부에서 authenticate()에 파라미터로 전달
		//AuthenticationProvider provider; //DaoAuthenticationProvider
		//UserDetailsService : usercheck
		//http.csrf().disable(); //csrf 
	}
	

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/favicon.ico*")
			.antMatchers("/css/**");
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}
