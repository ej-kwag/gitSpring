package di_exam2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Assembler {
	@Bean
	public Product LocalProduct() {
		return new LocalProduct();
	}
	
	@Bean
	public Product RemoteProduct() {
		return new RemoteProduct();
	}
}
