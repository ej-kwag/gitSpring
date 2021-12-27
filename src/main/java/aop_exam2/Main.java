package aop_exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
ApplicationContext context;
MemberVO vo;
	public Main() {
		context = new AnnotationConfigApplicationContext(MemberConfig.class);
		MemberInterface mi = (MemberInterface) context.getBean("getMemberDao");
		mi.delete();
		System.out.println("============================");
		mi.insert();
		
	}
	public static void main(String[] args) {
		new Main();
	}

}
