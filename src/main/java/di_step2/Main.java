package di_step2;

public class Main {
	public Main() {
		Assembler a = new Assembler();
		DB db = a.getDB();
		db.select();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
