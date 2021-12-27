package aop_aspectj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopAspectJConfig {
	
	@Bean
	public DB getStep2Mysql() {
		return new Mysql();
	}
	
	@Bean
	public DB getStep2Mssqyl() {
		return new Mssql();
	}
	
	@Bean
	public DB getStep2Oracle() {
		return new Oracle();
	}
	
	@Bean
	public Advice getAdvice() {
		return new Advice();
	}
	
}
