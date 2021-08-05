package co.bambbang.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.bambbang.prj.comm.Command;
import co.bambbang.prj.comm.DownloadFile;

public class FileDownLoad implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path="d://temp";
		String orgFileName = request.getParameter("orgFile");
		String downFileName = request.getParameter("downFile");
		
		DownloadFile downLoadFile = new DownloadFile(path, orgFileName, downFileName);
		boolean b = downLoadFile.isFileDown();
		if(!b) {
			request.setAttribute("message", "File downloaded successfully");
		}else {
			request.setAttribute("message", "File downloaded failed........");
		}
		
		return "fileList.do";
	}

}
