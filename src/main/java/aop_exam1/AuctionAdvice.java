package aop_exam1;

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
public class AuctionAdvice {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) MM:mm:ss:SS");
	Integer time = Integer.parseInt(sdf.format(new Date()).substring(14, 16));
	
	public void log() {
		System.out.println(sdf.format(new Date()));
		
	}
	
	@Before("execution(* aop_exam1.*.select(..))")
	public Object before(JoinPoint jp) {
		if(time<12) log();
		else System.out.println("16시를 경과하였습니다.");
		return null;
	}
	
	@After("execution(* aop_exam1.*.delete(..))")
	public Object after(JoinPoint jp) {
		if(time<16) log();
		return null;
	}
	
	@Around("execution(* aop_exam1.*.insert(..)) ||" +
			"execution(* aop_exam1.*.update(..)) " )
	public Object around(ProceedingJoinPoint jp) {
		try {
			if(time<16) {
				log();
				jp.proceed();
				log();
			}else {
				jp.proceed();
				System.out.println("16시를 경과하였습니다.");
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
}
