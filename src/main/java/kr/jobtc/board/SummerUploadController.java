package kr.jobtc.board;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class SummerUploadController {
	@RequestMapping(value="/summerUp")
	public void upload(@RequestParam("file") List<MultipartFile> mul,
						HttpServletRequest req,	HttpServletResponse resp,
						String flag) {
		resp.setContentType("text/html; charset=utf-8");
		try {
			PrintWriter out = resp.getWriter();
			String path = FileUploadController.uploadPath;
			UUID uuid = null;
			for(MultipartFile m : mul) {
				File targetFile = new File(path + m.getOriginalFilename());
				m.transferTo(targetFile);
				uuid = UUID.randomUUID();
				File temp = new File(path + uuid.toString() + "-" + m.getOriginalFilename());
				targetFile.renameTo(temp);
				
				out.print("./upload/" + uuid.toString() + "-" + m.getOriginalFilename());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/summerDelete")
	public void delete(HttpServletRequest req) {
		
		String target = req.getParameter("target");
		String[] temp = target.split("/");
		File delFile = new File(FileUploadController.uploadPath + temp[temp.length-1]);
		if(delFile.exists()) delFile.delete();
	}
}
