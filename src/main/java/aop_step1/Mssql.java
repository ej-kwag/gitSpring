package aop_step1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mssql implements DB{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss:SS");
	
	public Mssql() {
		System.out.println("Mssql().............");
	}

	@Override
	public void select() {
		System.out.println(sdf.format(new Date()));
		System.out.println("myssql select ~~~~~~~");
	}

	@Override
	public void insert() {
		System.out.println(sdf.format(new Date()));
		System.out.println("myssql insert ~~~~~~~");
	}

	@Override
	public void delete() {
		System.out.println(sdf.format(new Date()));
		System.out.println("myssql delete ~~~~~~~");
	}

	@Override
	public void update() {
		System.out.println(sdf.format(new Date()));
		System.out.println("myssql update ~~~~~~~");
	}
}
