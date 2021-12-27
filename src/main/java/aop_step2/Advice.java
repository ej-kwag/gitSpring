package aop_step2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Advice {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) MM:mm:ss:SS");
	
	public Advice() {
		System.out.println("advice()~~~~~~~~~");
	}
	
	public void beforeAdvice(DB db) {
		System.out.println(sdf.format(new Date()));
		db.select();
	}
	
	public void afterAdvice(DB db) {
		db.update();
		System.out.println(sdf.format(new Date()));
	}
	
	public void aroundAdvice(DB db) {
		System.out.println(sdf.format(new Date()));
		db.delete();
		System.out.println(sdf.format(new Date()));
	}
}
