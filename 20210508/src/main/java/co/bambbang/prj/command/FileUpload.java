package co.bambbang.prj.command;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imgscalr.Scalr;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.bambbang.prj.comm.Command;
import co.bambbang.prj.image.service.FileInfoService;
import co.bambbang.prj.image.vo.FileInformationVO;


public class FileUpload implements Command {
	// directory�� ����� �����Ѵٴ� ��. �̷��� �� �빮�ڷ� �̸��� �� �ش�.
	// ���� ������ ����� ������...

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// File upload
		FileInfoService fileDao = new FileInfoService();
		FileInformationVO vo = new FileInformationVO();

		int maxFileSize =1024 *1024*100; // 100MB �ִ����ϻ����� �������
		
		
		try {
			// MulitpartRequest(request, ������[, �ִ����ũ��, ���ڵ�ĳ���ͼ�, ������ ���ϸ� ��ȣ����]);
			// ���ϸ�ȣ: DefaultFileRenamePolicy => name.zip, name1.zip, ...
			MultipartRequest part = new MultipartRequest(request, "d:/temp/", maxFileSize, "utf-8", new DefaultFileRenamePolicy());
			
			
			//���⼭ ���� ���ε� �Ͼ
			String upFileName = part.getFilesystemName("fileName"); //���ε��� ���ϸ�
			String orgFileName = part.getOriginalFileName("fileName"); //�������ϸ� ���ϱ�
			String fileExt = orgFileName.substring(orgFileName.length()-4, orgFileName.length());
			
			
			vo.setSubject(part.getParameter("subject"));
			vo.setFileName(orgFileName);
			vo.setDownFile(upFileName);
			
			System.out.println(fileExt + " :Ȯ���� ");
			System.out.println(vo.getFileName() +"  : ���������̸�");
			
			File file = new File("d://temp/"+orgFileName);
			
			String fileName=vo.getFileName();
			String filePath="d://temp/"+ fileName;
			
			System.out.println(fileName+"  : �̸�");
			System.out.println(filePath +"  : path");
			
			
		//	makeThumbnail(file.getAbsolutePath(), orgFileName, fileExt);



			
			int n = fileDao.fileInsert(vo);
			
			if(n!=0) {
				request.setAttribute("message", vo.getFileName()+ " file uploaded :D ");
			}else {
				request.setAttribute("message", orgFileName + " file upload failed... :( ");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return "file/fileUploadResult";
	}
	
	private void makeThumbnail(String filePath, String fileName, String fileExt) throws Exception { 
		// ����� �������Ϸκ��� BufferedImage ��ü�� �����մϴ�.
		BufferedImage srcImg = ImageIO.read(new File(filePath)); 
		// ������� �ʺ�� ���� �Դϴ�.
		int dw = 250, dh = 150; 
		// ���� �̹����� �ʺ�� ���� �Դϴ�. 
		int ow = srcImg.getWidth(); int oh = srcImg.getHeight();
		// ���� �ʺ� �������� �Ͽ� ������� ������ ���̸� ����մϴ�.
		int nw = ow; int nh = (ow * dh) / dw; 
		// ���� ���̰� �������� ���ٸ� crop�� �ȵǹǷ� 
		// ���� ���̸� �������� ������� ������ �ʺ� ����մϴ�. 
		if(nh > oh) { nw = (oh * dw) / dh; nh = oh; } 
		// ���� ũ��� �����̹����� ������� crop �մϴ�. 
		BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);
		// crop�� �̹����� ������� �����մϴ�.
		BufferedImage destImg = Scalr.resize(cropImg, dw, dh);
		// ������� �����մϴ�. �̹��� �̸� �տ� "THUMB_" �� �ٿ� ǥ���߽��ϴ�.
		String thumbName = PATH + "THUMB_" + fileName; File thumbFile = new File(thumbName);
		ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
		}
	
	
	
	

}
