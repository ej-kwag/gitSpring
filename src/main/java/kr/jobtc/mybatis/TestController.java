package kr.jobtc.mybatis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.jobtc.board.BoardVO;
import kr.jobtc.member.MemberVO;

@RestController
public class TestController { //servlet 역할
	@Autowired
	TestService service;
	
	
	@RequestMapping("/su")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		int[] su = {1, 2, 3, 5, 7, 89, 9, 21, 2, 343, 5, 55, 227, 13, 468, 843, 873};
		mv.addObject("su", su);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/test1")
	public String test1(@RequestParam("abc") String mid) {
		System.out.println("mid=" + mid);
		return mid;
	}
	
	@RequestMapping("/test2")
	public String test2(HttpServletRequest req) {
		String mid = req.getParameter("abc");
		System.out.println("mid=" + mid);
		return mid;
	}
	
	@RequestMapping(value="/test3", method=RequestMethod.GET)
	public String test3(HttpServletRequest req) {
		String mid = req.getParameter("abc");
		System.out.println("mid="+mid);
		return mid;
	}
	
	@RequestMapping(value="/test4", method= {RequestMethod.GET, RequestMethod.POST})
	public String test4(HttpServletRequest req) {
			return "GET or POST accept";
	}
	
	@RequestMapping(value="/test5", method= {RequestMethod.GET})
	public BoardVO test5() {
		BoardVO vo = new BoardVO();
		vo.setMid("hong");
		vo.setSubject("안녕하세요");
		return vo;
	}
	
	@RequestMapping(value="/gugudan1", method= {RequestMethod.GET})
	public String gugudan(@RequestParam("dan") int dan) {
		String res = "";
		for(int i=1; i<10; i++) {
			res += i+"X"+dan+"="+i*dan+"<br/>";
		}
		return res;
	}
	
	@RequestMapping(value="/sum", method= {RequestMethod.GET})
	public String sum1(HttpServletRequest req) {
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		int c = a+b;
		String res = String.format("%d + %d = %d", a, b, c);
		System.out.println(res);
		return res;
	}
	
	@RequestMapping(value="/odd", method= {RequestMethod.GET})
	public List<Integer> odd(HttpServletRequest req) {
		List<Integer> list = new ArrayList<Integer>();
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		
		int s = (x%2==0)? x+1 : x ;
		
		for(int i = s; i<=y; i=i+2) {
			list.add(i);
		}
		return list;
	}
	
	@RequestMapping(value="/big", method= {RequestMethod.GET})
	public List<Integer> big(HttpServletRequest req){
		int x = Integer.parseInt(req.getParameter("x"));
		int[] list1 = {1, 2, 3, 5, 7, 89, 9, 21, 2, 343, 5, 55, 227, 13, 468, 843, 873};
		List<Integer> list = new ArrayList<Integer>();
		for(int i : list1) {
			if(i>x) {
				list.add(i);
			}
		}
		return list;
	}
	
	@RequestMapping(value="/find", method= {RequestMethod.GET})
	public List<String> find(@RequestParam("str") String findStr){
		String[] fruits = {"사과", "오렌지", "귤", "뀰", "딸기"};
		List<String> fruit = new ArrayList<String>();
		for(String chosen : fruits) {
			if(chosen.indexOf(findStr) >= 0) fruit.add(chosen);
		}
		return fruit;
	}
	
	@RequestMapping("/totSize")
	public String totSize() {
		String str = service.getTotList();
		System.out.println("BoardController.totSize().....");
		System.out.println("msg : " + str);
		return str;
	}
	
	/* mvc test */
	@RequestMapping("/mvc_test/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mvc_test/login");
		return mv;
	}
	
	@RequestMapping("/mvc_test/login_result")
	public ModelAndView loginR(MemberVO vo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("mvc_test/loginR");
		return mv;
	}
	
	@RequestMapping(value="/mvc_test/sum")
	public ModelAndView sum() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mvc_test/sum");
		return mv;
	}
	
	@RequestMapping(value="/mvc_test/max")
	public ModelAndView max() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mvc_test/max");
		return mv;
	}
	
	@RequestMapping(value="/mvc_test/range")
	public ModelAndView range() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mvc_test/range");
		return mv;
	}
	
	@RequestMapping(value="/mvc_test/sum_result")
	public ModelAndView sumR(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int x = Integer.parseInt(req.getParameter("figureX"));
		int y = Integer.parseInt(req.getParameter("figureY"));
		int r = service.sum(x, y);
		mv.addObject("req", req);
		mv.addObject("x", x);
		mv.addObject("y", y);
		mv.addObject("v", r);
		mv.setViewName("mvc_test/sum_result");
		return mv;
	}
	
	@RequestMapping(value="/mvc_test/max_result")
	public ModelAndView maxR(HttpServletRequest req) {
		//배열의 x~y번째 사이의 값에서 최대값을 찾으시오
		ModelAndView mv = new ModelAndView();
		List<Integer> list = new ArrayList<Integer>();
		int x = Integer.parseInt(req.getParameter("figureX"));
		int y = Integer.parseInt(req.getParameter("figureY"));
		int[] su = {1,2,34,5,7,8,2,3,455,6,7,8,19,922,455,32};
		x = (x>su.length-1)? su.length-1 : x;
		y = (y>su.length-1)? su.length-1 : y;
		if(x<y) {
			for (int i=x; i<=y; i++) {
				list.add(su[i]);
			}
		}else if(x>y) {
			for(int i =y; i<=x; i++) {
				list.add(su[i]);
			}
		}else if(x==y) {
			list.add(su[x]);
		}
		//기존 컨트롤러만 사용 int max = Collections.max(list);
		int max = Collections.max(service.max(x, y, su)); //service 사용
		mv.addObject("max", max);
		mv.setViewName("mvc_test/max_result");
		return mv;
	}
	
	@RequestMapping(value="/mvc_test/range_result")
	public ModelAndView rangeR(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int x = Integer.parseInt(req.getParameter("figureX"));
		int y = Integer.parseInt(req.getParameter("figureY"));
		/*기존 컨트롤러만 사용하는 방식
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
		*/
		List<Integer> list = service.range(x, y);
		mv.addObject("list", list);
		mv.setViewName("mvc_test/range_result");
		return mv;
	}
}
