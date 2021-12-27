package di_exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Assembler {
	@Bean
	public M getGuest() {
		return new Guest();
	}
	
	@Bean
	public M getMember() {
		return new Member();
	}
}
