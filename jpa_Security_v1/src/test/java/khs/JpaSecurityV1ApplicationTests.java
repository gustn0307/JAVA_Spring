package khs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class JpaSecurityV1ApplicationTests {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	//@Test
	void contextLoads() {
		String pass="1234";
		String encodedPass=passwordEncoder.encode(pass);
		
		System.out.println("encodedPass : "+encodedPass);
		// $2a$10$0JegC.U2dTq37FnX0MARlOr9rE1f56/4GUh0w1GfQkbkfWCuF7ZQW
	
		boolean result=passwordEncoder.matches("1234",encodedPass);
		System.out.println("패스워드 일치여부: "+result);
	}

}
