package di_step3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	ApplicationContext context;
	public Main() {
		context = new AnnotationConfigApplicationContext(Assembler.class);
		DB db = (DB) context.getBean("getDB");
		db.select();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
