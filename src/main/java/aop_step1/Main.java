package aop_step1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	ApplicationContext context;

	public Main() {
		context = new AnnotationConfigApplicationContext(AopStep1Config.class);
		DB mssql = (DB) context.getBean("getMssql");
		mssql.select();
		mssql.update();
		mssql.delete();
		mssql.insert();
		
		DB oracle = (DB) context.getBean("getOracle");
		oracle.select();
	}
	public static void main(String[] args) {
		new Main();
	}

}
