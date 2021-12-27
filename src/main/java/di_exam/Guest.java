package di_exam;

public class Guest implements M{
	public Guest() {
	}

	@Override
	public void select() {
		System.out.println("Guest select");
	}

	@Override
	public void insert() {
		System.out.println("Guest insert");
	}

	@Override
	public void update() {
		System.out.println("Guest update");
	}
}
