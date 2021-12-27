package kr.jobtc.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.jobtc.board.BoardAtt;
import kr.jobtc.board.BoardVO;
import kr.jobtc.board.Page;

@Repository
@Mapper
public interface BoardMapper {
	public Integer totSize(String findStr);
	public List<BoardVO> search(Page page);
	public BoardVO view(int serial);
	public void hit(int serial);
	public List<BoardAtt> attList(int grp);
	public int modifySave(BoardVO vo);
	
	public int delete(BoardVO vo);
	public int deleteAtt(List<String> delFile);
	public int deleteAttGrp (int grp);
	public int insert(BoardVO vo);
	public int attInsert(BoardAtt att);
	public int attModify(BoardAtt att);
	public void seqUp(BoardVO vo);
	public int repl(BoardVO vo);
	public int get_grp();
}
