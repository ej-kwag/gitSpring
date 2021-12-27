package di_exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	ApplicationContext context;
	
	public Main() {
		context = new AnnotationConfigApplicationContext(Assembler.class);
		Product localProduct = (Product) context.getBean("LocalProduct");
		localProduct.sale();
		localProduct.buy();
		localProduct.info();
		Product remoteProduct = (Product) context.getBean("RemoteProduct");
		remoteProduct.sale();
		remoteProduct.buy();
		remoteProduct.info();
	}

	public static void main(String[] args) {
		new Main();
	}

}
