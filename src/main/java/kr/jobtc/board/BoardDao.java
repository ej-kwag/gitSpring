package kr.jobtc.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactorySemi;

public class BoardDao {
	Page page;
	SqlSession session;
	BoardVO vo;
	AES aes;
	
	public BoardDao() {
		session = MybaFactorySemi.getFactory().openSession();
	}
	
	public List<BoardVO> search(Page page) {
		int totSize = session.selectOne("board.totSize", page.getFindStr());
		List<BoardVO> list = new ArrayList<BoardVO>();
		page.setTotSize(totSize);
		page.pageCompute();
		this.page = page;
		list = session.selectList("board.search", page);
		return list;
	}
	
	public BoardVO view(int serial) {
		List<BoardAtt> attList = null;
		BoardVO vo = new BoardVO();
		vo = session.selectOne("board.view", serial);
		attList = session.selectList("board.attList", serial);
		vo.setAttList(attList);
		int cnt = session.update("board.hit", serial);
		if(cnt>0) session.commit();
		else session.rollback();
		session.close();
		return vo;
	}
	
	public BoardVO viewAtt(int serial) {
		BoardVO vo = new BoardVO();
		vo = session.selectOne("board.viewAtt", serial);
		return vo;
	}
	
	public boolean modifySave(BoardVO vo) {
		boolean b = false;
		int cnt = session.update("board.modifySave", vo);
		if(cnt>0) {
			//boardAtt테이블 삭제
			if(vo.getDelList().size()>0) {
				session.delete("board.deleteAtt", vo.getDelList());
			}
			
			b=true;
			session.commit();
			for(String del : vo.getDelList()) {
				File delFile = new File(FileUpload.uploadPath + del);
				if(delFile.exists())delFile.delete();
			}
		}else {
			session.rollback();
		}
		session.close();
		return b;
	}
	
	public boolean delete(int serial, String pwd) {
		boolean b = false;
		aes = new AES();
		int c = 0;
		//doc 안에 있는 img 태그의 내용을 찾는 정규식
		String regex = "(<img src=\")(.+?)(\")";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		BoardVO vo = null;
		List<BoardAtt> attList = null;
		pwd = aes.encrypt(pwd);
		String path = "C:\\Users\\eunje\\eclipse-workspace\\WebProject\\src\\main\\webapp\\";
		
		vo = view(serial);
		vo.setPwd(pwd);
		session = MybaFactorySemi.getFactory().openSession();
		if(vo.getDoc()==null) {
			vo.setDoc("");
		}
		matcher = pattern.matcher(vo.getDoc());
		
		int cnt = session.delete("board.delete", vo);
		if (cnt > 0) {
			b = true;
			// 첨부 파일 정보를 삭제
			if (vo.getAttList().size() > 0) {
				c = session.delete("board.deleteAttGrp", serial);
			}

			// doc 안에 있는 이미지 파일 삭제
			while (matcher.find()) {
				File delFile = new File(path + matcher.group(2));
				if (delFile.exists())
					delFile.delete();
			}
			// 첨부 파일
			for (BoardAtt att : vo.getAttList()) {
				File delFile = new File(FileUpload.uploadPath + att.getAttFile());
				if (delFile.exists())
					delFile.delete();
			}
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return b;
	}
	
	public boolean d(BoardVO vo) {
		boolean b = false;
		try {
			int c = session.insert("board.insert", vo);
			if(c>0) {
				session.commit();
				b=true;
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return b;
	}
	
	public boolean insertAtt(BoardVO vo, String job) {
		boolean b = false;
		int c = 0;
		try {
			for (BoardAtt att : vo.getAttList()) {
				if(job.equals("i") || job.equals("r")) {
					c += session.insert("board.attInsert", att);
				}else if(job.equals("m")) {
					c += session.insert("board.attModify", att);
					}
			}
			if (c == vo.getAttList().size()) {
				session.commit();
				b=true;
			}else {
				session.rollback();
			}
			
			session.commit();
			b =true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return b;
	}
	
	public boolean repl(BoardVO vo) {
		boolean b = false;
		try {
			//같은 grp 내에 있는 본문글들 중에 seq가 본문글보다 큰 seq들의 값을 증가시킴
			session.update("board.seqUp", vo);
			int c = session.insert("board.repl", vo);
			if(c>0) {
				session.commit();
				b = true;
			}else {
				session.rollback();
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	
	

	public Page getPage() {return page;}
	public void setPage(Page page) {this.page = page;}

}
























