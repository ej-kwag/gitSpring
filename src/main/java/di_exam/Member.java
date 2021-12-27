package di_exam;

import java.util.List;

public class Member implements M {
	List<String> memberList;
	public Member() {
		
	}

	@Override
	public void select() {
		System.out.println("Member select");
	}

	@Override
	public void insert() {
		System.out.println("Member insert");
	}

	@Override
	public void update() {
		System.out.println("Member update");
	}
}
