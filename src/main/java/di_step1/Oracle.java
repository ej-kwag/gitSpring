package di_step1;

public class Oracle implements DB {
	@Override
	public void select() {
		System.out.println("oracle select ~~~");
	}

	public Oracle() {
		System.out.println("Oracle()........");
	}
}
