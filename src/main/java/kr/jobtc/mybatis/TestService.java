package kr.jobtc.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService { //dao역할
	@Autowired
	BoardMapper bmapper;
	
	public String getTotList() {
		String temp="전체 건수 : ";
		int totList = bmapper.totSize("");
		
		temp += totList;
		
		return temp;
	}
	
	public int sum(int x, int y) {
		return (x+y);
	}
	
	public List<Integer> max(int x, int y, int[] li) {
		List<Integer> list = new ArrayList<Integer>();
		if(x<y) {
			for (int i=x; i<=y; i++) {
				list.add(li[i]);
			}
		}else if(x>y) {
			for(int i=y; i<=x; i++) {
				list.add(li[i]);
			}
		}else if(x==y) {
			list.add(li[x]);
		}
		return list;
	}
	
	public List<Integer> range(int x, int y){
		List<Integer> list = new ArrayList<Integer>();
		if(x<y) {
			for (int i =x; i<=y; i++) {
				list.add(i);
			}			
		}else if(x>y) {
			for(int i =y; i<=x; i++) {
				list.add(i);
			}
		}else if(x==y) {
			list.add(x);
		}
		
		return list;
	}
}
