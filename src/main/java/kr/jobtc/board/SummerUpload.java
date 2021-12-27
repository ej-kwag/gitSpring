package kr.jobtc.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		location = "C:/Temp/",
		maxFileSize = -1,
		maxRequestSize = -1,
		fileSizeThreshold = 2000
)

@WebServlet(urlPatterns = "*.summerUp")
public class SummerUpload extends HttpServlet{
	String job;
	public static String uploadPath = "C:/Users/eunje/eclipse-workspace/WebProject/src/main/webapp/upload/";
	UUID uuid = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		if(req.getParameter("job")!=null) {
			job = req.getParameter("job");
		}
		PrintWriter out = resp.getWriter();
		String flag = ""; //삭제 시
		if(req.getParameter("flag")!=null) {
			flag = req.getParameter("flag");
		}

		if(flag.equals("delete")) {
			String target = req.getParameter("target");
			String[] temp = target.split("/");
			File delFile = new File(uploadPath + temp[temp.length-1]);
			if(delFile.exists()) delFile.delete();
			
		}else {
			Collection<Part> parts = req.getParts();
			for (Part p : parts) {
				if (p.getHeader("Content-Disposition").contains("filename=")) {
					if (p.getSize() <= 0)	continue;
					uuid = UUID.randomUUID();
					String temp = String.format("%s-%s", uuid.getLeastSignificantBits(), p.getSubmittedFileName());
					p.write(uploadPath + temp);
					p.delete();
					
					out.print("./upload/"+temp); //ajax에게 저장 정보를 리턴
				}
			}
		}
	}
}
