package aop_step1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopStep1Config {
	@Bean
	public DB getMssql() {
		return new Mssql();
	}
	
	@Bean
	public DB getMysql() {
		return new Mysql();
	}
	
	@Bean
	public DB getOracle() {
		return new Oracle();
	}
}
