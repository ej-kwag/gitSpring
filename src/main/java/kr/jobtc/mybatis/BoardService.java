package kr.jobtc.mybatis;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import kr.jobtc.board.AES;
import kr.jobtc.board.BoardAtt;
import kr.jobtc.board.BoardVO;
import kr.jobtc.board.FileUpload;
import kr.jobtc.board.Page;

@Service
@Transactional
public class BoardService {
	@Autowired
	BoardMapper mapper; //mapper가 session(=mybafactory.getFactory().openSession())역할을 함.
	
	@Autowired
	PlatformTransactionManager manager;
	
	TransactionStatus status;
	Page page;
	AES aes;
	int grp;
	
	public List<BoardVO> search(Page page){
		List<BoardVO> list = null;

		int totSize = mapper.totSize(page.getFindStr());
		page.setTotSize(totSize);
		this.page = page;
		
		list = mapper.search(page);
		
		return list;
	}
	
	public boolean insert(BoardVO vo) {
		boolean b = false;
		status = manager.getTransaction(new DefaultTransactionDefinition());
		
		int c = mapper.insert(vo);
		if(c>0) {
			manager.commit(status);
			grp = mapper.get_grp();
			b=true;
		}else {
			manager.rollback(status);
		}
		
		return b;
	}
	
	public BoardVO view(int serial, char mode) {
		status = manager.getTransaction(new DefaultTransactionDefinition());
		BoardVO vo = null;
		List<BoardAtt> attList = null;
		
		if(mode == 'v') {
			mapper.hit(serial);
			manager.commit(status);
		}
		vo = mapper.view(serial);
		attList = mapper.attList(serial);
		vo.setAttList(attList);
		
		return vo;
	}
	
	public boolean modifySave(BoardVO vo) {
		status = manager.getTransaction(new DefaultTransactionDefinition());
		boolean b = false;
		int cnt = mapper.modifySave(vo);
		if(cnt>0) {
			//boardAtt테이블 삭제
			if(vo.getDelList().size()>0) {
				mapper.deleteAtt(vo.getDelList());
			}
			
			manager.commit(status);
			
			b=true;
			for(String del : vo.getDelList()) {
				File delFile = new File(FileUpload.uploadPath + del);
				if(delFile.exists())delFile.delete();
			}
		}else {
			manager.rollback(status);
		}
		return b;
	}
	
	public boolean delete(int serial, String pwd) {
		status = manager.getTransaction(new DefaultTransactionDefinition());
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
		String path ="C:\\Users\\eunje\\eclipse-workspace\\GitSpring\\src\\main\\webapp\\WEB-INF\\upload\\";
		vo = view(serial, 'd');
		vo.setPwd(pwd);
		if(vo.getDoc()==null) {
			vo.setDoc("");
		}
		matcher = pattern.matcher(vo.getDoc());
		
		int cnt = mapper.delete(vo);
		if (cnt > 0) {
			b = true;
			// 첨부 파일 정보를 삭제
			if (vo.getAttList().size() > 0) {
				c = mapper.deleteAttGrp(serial);
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
			manager.commit(status);
		}else {
			manager.rollback(status);
		}
		return b;
	}
	
	public boolean insertAtt(BoardVO vo, String job) {
		boolean b = false;
		status = manager.getTransaction(new DefaultTransactionDefinition());

		int c = 0;
		try {
			for (BoardAtt att : vo.getAttList()) {
				if(job.equals("i") || job.equals("r")) {
					c += mapper.attInsert(att);
				}
			}
			if (c == vo.getAttList().size()) {
				manager.commit(status);
				b=true;
			}else {
				manager.rollback(status);
			}
			
			b =true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean repl(BoardVO vo) {
		boolean b = false;
		try {
			//같은 grp 내에 있는 본문글들 중에 seq가 본문글보다 큰 seq들의 값을 증가시킴
			mapper.seqUp(vo);
			int c = mapper.insert(vo);
			if(c>0) {
				manager.commit(status);
				b = true;
			}else {
				manager.rollback(status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public Page getPage() {return page;}
	public void setPage(Page page) {this.page = page;}
	public int getGrp() {return grp;}

	
}
