package aop_step1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Oracle implements DB {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss:SS");
	
	public Oracle() {
		System.out.println("Oracle()........");
	}
	
	@Override
	public void select() {
		System.out.println(sdf.format(new Date()));
		System.out.println("oracle select ~~~");
		System.out.println(sdf.format(new Date()));
	}

	@Override
	public void insert() {
		System.out.println(sdf.format(new Date()));
		System.out.println("oracle insert ~~~");
		System.out.println(sdf.format(new Date()));
	}

	@Override
	public void delete() {
		System.out.println(sdf.format(new Date()));
		System.out.println("oracle delete ~~~");
		System.out.println(sdf.format(new Date()));
	}

	@Override
	public void update() {
		System.out.println(sdf.format(new Date()));
		System.out.println("oracle update ~~~");
		System.out.println(sdf.format(new Date()));
	}
}
