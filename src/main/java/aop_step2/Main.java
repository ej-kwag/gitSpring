package aop_step2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	ApplicationContext context;
	
	public Main() {
		context = new AnnotationConfigApplicationContext(AopStep2Config.class);
		DB db = (DB) context.getBean("getAopStep2Mssql");
		db.select();
		
		Advice ad = (Advice)context.getBean("getAopStep2Advice");
		System.out.println("============================");
		ad.beforeAdvice(db);
		System.out.println("============================");
		ad.afterAdvice(db);
		System.out.println("============================");
		ad.aroundAdvice(db);
	}
	public static void main(String[] args) {
		new Main();
	}

}
