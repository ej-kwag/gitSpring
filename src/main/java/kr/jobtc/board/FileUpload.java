package kr.jobtc.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import kr.jobtc.mybatis.BoardService;

@MultipartConfig(
		location = "C:/Temp/",
		maxFileSize = -1,
		maxRequestSize = -1,
		fileSizeThreshold = 2000
)

@WebServlet(urlPatterns = "*.boardUp")
public class FileUpload extends HttpServlet{
	BoardVO vo;
	AES aes;
	boolean b;
	
	@Autowired
	BoardService dao;
	
	Page page;
	RequestDispatcher rd = null;
	String url = "index.jsp?sub=./board/";
	public static String uploadPath = "C:/Users/eunje/eclipse-workspace/WebProject/src/main/webapp/upload/";
	String msg;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String job = "";
		String grp = "";
		//req.setCharacterEncoding("utf-8");
		//resp.setContentType("text/html;charset=utf-8");
		job = req.getParameter("job");
		dao = new BoardDao();
		aes = new AES();
		vo = new BoardVO();
		page = new Page();
		List<BoardAtt> attList = new ArrayList<BoardAtt>();
		List<BoardAtt> delList = new ArrayList<BoardAtt>();
		Collection<Part> parts = req.getParts();
		UUID uuid = UUID.randomUUID();
		
		String nowPage = req.getParameter("nowPage");
		String findStr = req.getParameter("findStr");
		
		if(req.getParameter("grp")!=null) grp = req.getParameter("grp");
		
		page.setNowPage(Integer.parseInt(nowPage));
		page.setFindStr(findStr);
		
		for (Part p : parts) {
			if (p.getHeader("Content-Disposition").contains("filename=")) {
				if (p.getSize() <= 0) continue;
				String temp = String.format("%s-%s", uuid.getLeastSignificantBits(), p.getSubmittedFileName());
				p.write(uploadPath + temp);
				p.delete();

				BoardAtt att = new BoardAtt();
				if(req.getParameter("grp")!=null) {
					att.setGrp(Integer.parseInt(grp));
				}
				att.setAttFile(temp);
				attList.add(att);
			}
		}
		if(req.getParameter("grp")!=null) {
		vo.setGrp(Integer.parseInt(grp));
		}
		
		vo.setAttList(attList);
		req.setAttribute("vo", vo);
		req.setAttribute("page", page);
		
		switch(job){
			case "m" :
				b = dao.insertAtt(vo, job);
				if(b) msg="자료 수정 성공";
				else msg="자료 수정 중 오류 발생";
				break;
			case "r" :
			case "i" :
				b = dao.insertAtt(vo, job);
				if(b) {
					msg = "자료 입력 성공";
				}else {
					msg="자료 입력 중 오류 발생";
				}
				break;
		}
		req.setAttribute("msg", msg);
		rd = req.getRequestDispatcher(url + "result.jsp");
		rd.forward(req, resp);
	}
	
}
