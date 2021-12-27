package aop_aspectj;

import java.text.SimpleDateFormat;

public class Mssql implements DB{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss:SS");
	
	public Mssql() {
		System.out.println("Mssql().............");
	}

	@Override
	public void select() {
		System.out.println("myssql select ~~~~~~~");
	}

	@Override
	public void insert() {
		System.out.println("myssql insert ~~~~~~~");
	}

	@Override
	public void delete() {
		System.out.println("myssql delete ~~~~~~~");
	}

	@Override
	public void update() {
		System.out.println("myssql update ~~~~~~~");
	}
}
