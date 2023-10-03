package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	@Test
	public void testEncoderPassword() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPasswordn = "1234567";
		String encodedPassword = passwordEncoder.encode(rawPasswordn);
		
		System.out.println(encodedPassword);
		
		boolean matches = passwordEncoder.matches(rawPasswordn, encodedPassword);
		
		assertThat(matches).isTrue();
		
	}

}
