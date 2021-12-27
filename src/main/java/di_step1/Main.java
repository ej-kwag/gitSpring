package di_step1;

public class Main {
	public Main() {
		DB sql = new Mysql();
		sql.select();
		
		sql = new Oracle();
		sql.select();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
