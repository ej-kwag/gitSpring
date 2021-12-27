package di_step2;

//외부 조립기(외부에서 객체를 생성하여 제공하는 클래스)

public class Assembler {
	public DB getDB() {
		DB db = new Oracle();
		return db;
	}
}
