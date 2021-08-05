package co.bambbang.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.bambbang.prj.comm.Command;
import co.bambbang.prj.image.service.FileInfoService;

public class FileList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		FileInfoService fileDao = new FileInfoService();
		
		request.setAttribute("files", fileDao.fileSelectList());
		
		return "file/fileList";
	}

}
