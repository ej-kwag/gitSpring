package kr.jobtc.board;

import java.util.ArrayList;
import java.util.List;

public class BoardVO {
	int serial;
	String mid;
	String subject;
	String doc;
	String pwd;
	String mdate;
	int hit;
	int grp;
	int seq;
	int deep;
	int attCnt;
	List<BoardAtt> attList = new ArrayList<BoardAtt>();
	List<String> delList = new ArrayList<String>();
	
	
	public int getSerial() {return serial;}
	public void setSerial(int serial) {this.serial = serial;}
	public String getMid() {return mid;}
	public void setMid(String mid) {this.mid = mid;}
	public String getSubject() {return subject;}
	public void setSubject(String subject) {this.subject = subject;}
	public String getDoc() {return doc;}
	public void setDoc(String doc) {this.doc = doc;}
	public String getPwd() {return pwd;}
	public void setPwd(String pwd) {this.pwd = pwd;}
	public String getMdate() {return mdate;}
	public void setMdate(String mdate) {this.mdate = mdate;}
	public int getHit() {return hit;}
	public void setHit(int hit) {this.hit = hit;}
	public int getGrp() {return grp;}
	public void setGrp(int grp) {this.grp = grp;}
	public int getSeq() {return seq;}
	public void setSeq(int seq) {this.seq = seq;}
	public int getDeep() {return deep;}
	public void setDeep(int deep) {this.deep = deep;}
	public int getAttCnt() {
		return attCnt;
	}
	public void setAttCnt(int attCnt) {this.attCnt = attCnt;}
	public List<BoardAtt> getAttList() {return attList;}
	public void setAttList(List<BoardAtt> attList) {this.attList = attList;}
	public List<String> getDelList() {return delList;}
	public void setDelList(List<String> delList) {this.delList = delList;}
	
}
