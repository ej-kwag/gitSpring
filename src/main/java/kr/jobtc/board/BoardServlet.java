package kr.jobtc.board;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "*.brd")
@MultipartConfig
public class BoardServlet extends HttpServlet{
	String url = "index.jsp?sub=./board/";
	RequestDispatcher rd;
	String job="";
	Page page;
	BoardDao dao;
	boolean b;
	String msg;
	AES aes = new AES();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		job = "list";
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		page = new Page();
		dao = new BoardDao();
		String serial = "";
		if(req.getParameter("job")!=null) job = req.getParameter("job");
		if(req.getParameter("serial")!=null) serial = req.getParameter("serial");
		if(req.getParameter("nowPage")!=null) page.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		if(req.getParameter("findStr")!=null) page.setFindStr(req.getParameter("findStr"));
		req.setAttribute("page", page);
		
		switch(job) {
		case "list"	:
			List<BoardVO> list = dao.search(page);
			page = dao.getPage();
			req.setAttribute("page", page);
			req.setAttribute("list", list);
			rd = req.getRequestDispatcher(url + "list.jsp");
			rd.forward(req, resp);
			break;
		case "view" :
			BoardVO vo = dao.view(Integer.parseInt(req.getParameter("serial")));
			req.setAttribute("vo", vo);
			rd = req.getRequestDispatcher(url + "view.jsp");
			rd.forward(req, resp);
			break;
		case "insert" :
			rd = req.getRequestDispatcher(url + "insert.jsp");
			rd.forward(req, resp);
			break;
		case "insertSave" :
			vo = setVO(req);
			b = dao.insert(vo);
			//js 작업 때문에 forward를 하면 안 됨. rd.forward(req, resp);
			break;
		case "modify" :
			vo = dao.view(Integer.parseInt(req.getParameter("serial")));
			req.setAttribute("vo", vo);
			rd = req.getRequestDispatcher(url + "modify.jsp");
			rd.forward(req, resp);
			break;
		case "reply" :
			vo = setVO(req);
			req.setAttribute("page", page);
			req.setAttribute("vo", vo);
			rd = req.getRequestDispatcher(url + "repl.jsp");
			rd.forward(req, resp);
			break;
		case "delete" :
			boolean b = dao.delete(Integer.parseInt(req.getParameter("serial")), req.getParameter("pwd"));
			if(b) msg="삭제 성공.";
			else msg="삭제 중 오류 발생.";
			req.setAttribute("msg", msg);
			rd = req.getRequestDispatcher(url + "result.jsp");
			rd.forward(req, resp);		
			break;
		case "modifySave" :
			vo = setVO(req);
			serial = req.getParameter("serial");
			vo.setSerial(Integer.parseInt(serial));
			req.setAttribute("vo",vo);
			b = dao.modifySave(vo);
			break;
		case "replSave" :
			vo = setVO(req);
			b = dao.repl(vo);
			break;
		}
	}
	
	public BoardVO setVO(HttpServletRequest req) {
		BoardVO vo = new BoardVO();
		vo.setMid(req.getParameter("mid"));
		vo.setPwd(aes.encrypt(req.getParameter("pwd")));
		vo.setSubject(req.getParameter("subject"));
		vo.setDoc(req.getParameter("doc"));
		
		if(job.equals("modifySave")) {
			String[] delFile = req.getParameterValues("delFile");
			if(delFile!=null) {
				vo.setDelList(Arrays.asList(delFile));
			}
			vo.setSerial(Integer.parseInt(req.getParameter("serial")));
		}else if(job.equals("replSave") || job.equals("reply")) {
			vo.setGrp(Integer.parseInt(req.getParameter("grp")));
			vo.setDeep(Integer.parseInt(req.getParameter("deep")));
			vo.setSeq(Integer.parseInt(req.getParameter("seq")));
			req.setAttribute("vo", vo);
		}
		return vo;
	}
}
