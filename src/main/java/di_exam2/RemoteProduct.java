package di_exam2;

public class RemoteProduct implements Product {

	@Override
	public void sale() {
		System.out.println("RemoteProduct sale");
	}

	@Override
	public void buy() {
		System.out.println("RemoteProduct buy");
	}

	@Override
	public void info() {
		System.out.println("RemoteProduct info");
	}

}
