package di_exam2;

public class LocalProduct implements Product{

	@Override
	public void sale() {
		System.out.println("LocalProduct sale");
	}

	@Override
	public void buy() {
		System.out.println("LocalProduct buy");
	}

	@Override
	public void info() {
		System.out.println("LocalProduct info");
	}

}
