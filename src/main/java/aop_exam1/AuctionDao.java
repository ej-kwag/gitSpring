package aop_exam1;

public class AuctionDao implements AuctionInterface{

	@Override
	public void insert() {
		System.out.println("insert ~~~~~~");
		
	}

	@Override
	public void update() {
		System.out.println("update ~~~~~~");
	}

	@Override
	public void delete() {
		System.out.println("delete ~~~~~~");
	}

	@Override
	public void select() {
		System.out.println("select ~~~~~~");
	}

}
