package aop_aspectj;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Advice {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) MM:mm:ss:SS");
	public void log() {
		System.out.println(sdf.format(new Date()));
	}
	
	@Before("execution(* aop_aspectj.*.select(..))")
	public Object before(JoinPoint jp) {
		log();
		return null;
	}

	@After("execution(* aop_aspectj.*.update(..))")
	public Object after(JoinPoint jp) {
		log();
		return null;
	}

	@Around("execution(* aop_aspectj.*.delete(..))")
	public Object around(ProceedingJoinPoint jp) {
		try {
			log();
			jp.proceed();
			log();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
