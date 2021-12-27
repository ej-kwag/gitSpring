package kr.jobtc.board;

public class BoardAtt {
	int Serial;
	int grp;
	String attFile;
	String delFile;
	
	public int getSerial() {return Serial;}
	public void setSerial(int serial) {Serial = serial;}
	public int getGrp() {return grp;}
	public void setGrp(int grp) {this.grp = grp;}
	public String getAttFile() {return attFile;}
	public void setAttFile(String attFile) {this.attFile = attFile;}
	public String getDelFile() {
		return delFile;
	}
	public void setDelFile(String delFile) {
		this.delFile = delFile;
	}
	
}
