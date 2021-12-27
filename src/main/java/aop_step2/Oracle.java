package aop_step2;

import java.text.SimpleDateFormat;

public class Oracle implements DB {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss:SS");
	
	public Oracle() {
		System.out.println("Oracle()........");
	}
	
	@Override
	public void select() {
		System.out.println("oracle select ~~~");
	}

	@Override
	public void insert() {
		System.out.println("oracle insert ~~~");
	}

	@Override
	public void delete() {
		System.out.println("oracle delete ~~~");
	}

	@Override
	public void update() {
		System.out.println("oracle update ~~~");
	}
}
