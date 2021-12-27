package di_step2;

public class Mysql implements DB{
	@Override
	public void select() {
		System.out.println("mysql select ~~~");
	}

	public Mysql() {
		System.out.println("mysql().....");
	}
	
}
