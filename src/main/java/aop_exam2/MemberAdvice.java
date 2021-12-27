package aop_exam2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class MemberAdvice {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) MM:mm:ss:SS");
	MemberVO vo;
	
	public void log() {
		System.out.println(sdf.format(new Date()));
	}
	
	public void identity() {
		System.out.println(vo.identity);
	}
	
	/*
	
	@After("execution(* aop_exam2.*.insert(..)) ||" +
			"execution(* aop_exam2.*.update(..)) ||" +
			"execution(* aop_exam2.*.delete(..)) ||" +
			"execution(* aop_exam2.*.select(..)) " )
	public Object after(JoinPoint jp) {
		if(vo.identity.equals("admin")) {
		System.out.println("성공적으로 완료되었습니다.");
		log();
		}else System.out.println("권한이 없습니다.");
		
		return null;
	}
	*/
	@Before("execution(* aop_exam2.*.view(..))")
	public Object before(JoinPoint jp) {
		System.out.println("성공적으로 완료되었습니다.");
		log();
		return null;
	}
	
	@Around("execution(* aop_exam2.*.insert(..)) ||" +
			"execution(* aop_exam2.*.update(..)) ||" +
			"execution(* aop_exam2.*.delete(..)) ||" +
			"execution(* aop_exam2.*.select(..)) " )
	public Object around(ProceedingJoinPoint jp) {
		vo = new MemberVO("admin");
		try {
			if(vo.getIdentity().equals("admin")) {
				System.out.println("권한 : "); identity();
				jp.proceed();
				log();
			}else System.out.println("권한이 없습니다.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
}
