package aop_exam2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MemberConfig {
	@Bean
	public MemberInterface getMemberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberAdvice getMemberAdvice() {
		return new MemberAdvice();
	}
}
