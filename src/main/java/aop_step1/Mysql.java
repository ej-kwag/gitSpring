package aop_step1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mysql implements DB{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss:SS");
	
	public Mysql() {
		System.out.println("mysql().....");
	}

	@Override
	public void select() {
		System.out.println("mysql select ~~~");
		System.out.println(sdf.format(new Date()));
	}

	@Override
	public void insert() {
		System.out.println("mysql insert ~~~");
		System.out.println(sdf.format(new Date()));
	}

	@Override
	public void delete() {
		System.out.println("mysql delete ~~~");
		System.out.println(sdf.format(new Date()));
	}

	@Override
	public void update() {
		System.out.println("mysql update ~~~");
		System.out.println(sdf.format(new Date()));
	}
	
}
