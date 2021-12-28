package kr.jobtc.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.jobtc.mybatis.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService service;
	Page page = new Page();
	String msg="";
	AES aes = new AES();
	int serial;
	int grp = 0;
	String pwd = "";
	BoardVO vo = null;
	boolean b = false;
	PrintWriter out;
	
	@RequestMapping(value="/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/list", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<BoardVO> list = service.search(page);
		page = service.getPage();
		
		mv.addObject("page", page);
		mv.addObject("list", list);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@RequestMapping(value="/view", method= {RequestMethod.POST})
	public ModelAndView view(int serial, Page page) {
		ModelAndView mv = new ModelAndView();
		vo = service.view(serial, 'v');
		mv.addObject("vo", vo);
		mv.addObject("page", page);
		mv.setViewName("board/view");
		return mv;
	}
	
	@RequestMapping(value="/insert", method= {RequestMethod.POST}) //서블렛의 case : insert일 때
	public ModelAndView insert(Page page) {
		ModelAndView mv = new ModelAndView();
		b = service.insert(vo);
		mv.addObject("vo", vo);
		mv.addObject("page", page);
		mv.setViewName("board/insert");
		return mv;
	}
	
	@RequestMapping(value="/insertSave", method= {RequestMethod.POST})
	public void insertSave(BoardVO vo, HttpServletResponse resp) {
		try {
			out = resp.getWriter();
			this.b = service.insert(vo);
			this.grp = service.getGrp();
			String temp="{'flag':'%s', 'grp':'%s'}";
			String flag = "";
			if(b) {
				flag = "OK";
			}else {
				flag = "fail";
			}
			String json = String.format(temp, flag, grp);
			json = json.replaceAll("'", "\"");
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/modify", method= {RequestMethod.POST})
	public ModelAndView modify(int serial, Page page) {
		ModelAndView mv = new ModelAndView();
		vo = service.view(serial, 'm');
		mv.addObject("vo", vo);
		mv.addObject("page", page);
		mv.setViewName("board/modify");
		
		return mv;
	}
	
	@RequestMapping(value="/modifySave", method= {RequestMethod.POST})
	public void modifySave(BoardVO vo, Page page, HttpServletResponse resp) {
		try {
			b = service.modifySave(vo);
			out = resp.getWriter();
			String temp="{'flag':'%s', 'grp':'%s'}";
			String flag = "";
			if(b) {
				flag = "OK";
			}else {
				flag = "fail";
			}
			String json = String.format(temp, flag, grp);
			json = json.replaceAll("'", "\"");
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.POST})
	public ModelAndView delete(HttpServletRequest req, Page page) {
		ModelAndView mv = new ModelAndView();
		serial = Integer.parseInt(req.getParameter("serial"));
		pwd = req.getParameter("pwd");
		b = service.delete(serial, pwd);
		if(b) msg="자료가 삭제 되었습니다.";
		else msg="자료 삭제 중 오류 발생";
		
		mv.addObject("msg", msg);
		mv.addObject("page", page);
		mv.setViewName("board/result");
		return mv;
	}
	
	@RequestMapping(value="/repl", method= {RequestMethod.POST})
	public ModelAndView repl(BoardVO vo, Page page) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.addObject("page", page);
		mv.setViewName("board/repl");
		return mv;
	}
	
	@RequestMapping(value="/replSave", method= {RequestMethod.POST})
	public void replSave(BoardVO vo, Page page, HttpServletResponse resp) {
		try {
			b = service.repl(vo);
			out = resp.getWriter();
			String temp="{'flag':'%s', 'grp':'%s'}";
			String flag = "";
			if(b) {
				flag = "OK";
			}else {
				flag = "fail";
			}
			String json = String.format(temp, flag, grp);
			json = json.replaceAll("'", "\"");
			out.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
