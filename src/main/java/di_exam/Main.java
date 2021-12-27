package di_exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	ApplicationContext context;
	
	public Main() {
		context = new AnnotationConfigApplicationContext(Assembler.class);
		M guest = (M) context.getBean("getGuest");
		guest.select();
		guest.insert();
		guest.update();
		
		M member = (M) context.getBean("getMember");
		member.select();
		member.insert();
		member.update();
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
