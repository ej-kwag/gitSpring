package aop_step2;

import java.text.SimpleDateFormat;

public class Mysql implements DB{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss:SS");
	
	public Mysql() {
		System.out.println("mysql().....");
	}

	@Override
	public void select() {
		System.out.println("mysql select ~~~");
	}

	@Override
	public void insert() {
		System.out.println("mysql insert ~~~");
	}

	@Override
	public void delete() {
		System.out.println("mysql delete ~~~");
	}

	@Override
	public void update() {
		System.out.println("mysql update ~~~");
	}
	
}
