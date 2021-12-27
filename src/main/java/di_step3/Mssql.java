package di_step3;

public class Mssql implements DB{
	public Mssql() {
		System.out.println("Mssql().............");
	}

	@Override
	public void select() {
		System.out.println("myssql select ~~~~~~~");
	}
}
