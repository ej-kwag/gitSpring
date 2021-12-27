package aop_exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	ApplicationContext context;
	public Main() {
		context = new AnnotationConfigApplicationContext(AuctionConfig.class);
		AuctionInterface ai = (AuctionInterface) context.getBean("getAuctionDao");
		ai.delete();
		System.out.println("========================");
		ai.select();
		System.out.println("========================");
		ai.insert();
		System.out.println("========================");
		ai.update();
	}
	public static void main(String[] args) {
		new Main();
	}

}
