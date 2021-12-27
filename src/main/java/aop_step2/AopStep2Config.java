package aop_step2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopStep2Config {

	@Bean
	public DB getAopStep2Mysql() {
		return new Mysql();
	}
	
	@Bean
	public DB getAopStep2Mssql() {
		return new Mssql();
	}
	
	@Bean
	public DB getAopStep2Oracle() {
		return new Oracle();
	}
	
	@Bean
	public Advice getAopStep2Advice() {
		return new Advice();
	}
	
}
