package aop_aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	ApplicationContext context;
	public Main() {
		context = new AnnotationConfigApplicationContext(AopAspectJConfig.class);
		
		DB db = (DB)context.getBean("getStep2Mysql");
		System.out.println("=====================");
		db.select();
		System.out.println("=====================");
		db.update();
		System.out.println("=====================");
		db.delete();
		
	}

	public static void main(String[] args) {
		new Main();
	}

}
