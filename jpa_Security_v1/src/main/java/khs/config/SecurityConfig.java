package khs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter { // WebSecurityConfigurerAdapter는 독립적으로 사용불가, configure()를 오버라이드해서 사용자정의해서 사용
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http); // 주석처리하면 인증을 안해도 접근가능
		http.authorizeRequests()
			.antMatchers("/","/test/all").permitAll() // permitAll()로 해당 URL은 권한없이 접근가능
			.antMatchers("/test/member").hasRole("USER") // 해당 url은 user 롤만 가짐 => 로그인 필요한 페이지 접근시 활용가능 ex)회원정보 보기
			.antMatchers("/test/admin").hasRole("ADMIN") // 해당 url은 admin 롤만 가짐
			.anyRequest().authenticated();
//		http.authorizeRequests()
//			.anyRequest().authenticated(); // 다른 리퀘스트들은 권한없어서 접근불가
		
		http.formLogin(); // 인증 문제시 로그인 화면으로 이동
	} 
	
//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	// AuthenticationManager 설정을 쉽게 처리할 수 있도록 도와주는 메소드 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		//super.configure(auth);
		auth.inMemoryAuthentication().withUser("test") // 인증 테스트용 회원정보 하나 만들기
									.password("$2a$10$0JegC.U2dTq37FnX0MARlOr9rE1f56/4GUh0w1GfQkbkfWCuF7ZQW") //password 인코딩
									.roles("USER"); // USER 권한 적용(USER, ADMIN 등의 권한을 적용가능)
		
	}


	// 반드시 필요한 PasswordEncoder, spring boot 2.0부터는 인증을 위해서는 반드시 PasswordEncoder 지정해야 한다
	@Bean
	PasswordEncoder passwoerEncoder() {
		return new BCryptPasswordEncoder(); // 인자값으로 암호화 강도를 4~31까지 넣어줄 수 있다.
	} 
	// BCrypt라는 패스워드 암호화 목적으로 설계된 클래스
	// 복호화가 불가능하고, 매번 다른 값으로 암호화된다.
}
