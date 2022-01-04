package kr.jobtc.board;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
	@Bean
	public AES getAES() {
		return new AES();
	}
}
