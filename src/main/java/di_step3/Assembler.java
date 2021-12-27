package di_step3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Assembler {
	@Bean
	public DB getDB() {
		return new Oracle();
	}
}
