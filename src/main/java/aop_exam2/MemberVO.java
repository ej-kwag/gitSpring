package aop_exam2;

public class MemberVO {
	public String identity;

	public String getIdentity() {return identity;}
	public void setIdentity(String identity) {this.identity = identity;}
	
	public MemberVO(String m) {
		this.identity = m;
	}
}
