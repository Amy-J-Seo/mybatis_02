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
	// directory를 상수로 정의한다는 뜻. 이럴땐 다 대문자로 이름을 써 준다.
	// 실제 파일이 저장될 공간임...

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// File upload
		FileInfoService fileDao = new FileInfoService();
		FileInformationVO vo = new FileInformationVO();

		int maxFileSize =1024 *1024*100; // 100MB 최대파일사이즈 정해쥬기
		
		
		try {
			// MulitpartRequest(request, 저장경로[, 최대허용크기, 인코딩캐릭터셋, 동일한 파일명 보호여부]);
			// 파일명보호: DefaultFileRenamePolicy => name.zip, name1.zip, ...
			MultipartRequest part = new MultipartRequest(request, "d:/temp/", maxFileSize, "utf-8", new DefaultFileRenamePolicy());
			
			
			//여기서 파일 업로드 일어남
			String upFileName = part.getFilesystemName("fileName"); //업로드한 파일명
			String orgFileName = part.getOriginalFileName("fileName"); //원본파일명 구하기
			String fileExt = orgFileName.substring(orgFileName.length()-4, orgFileName.length());
			
			
			vo.setSubject(part.getParameter("subject"));
			vo.setFileName(orgFileName);
			vo.setDownFile(upFileName);
			
			System.out.println(fileExt + " :확장자 ");
			System.out.println(vo.getFileName() +"  : 원본파일이름");
			
			File file = new File("d://temp/"+orgFileName);
			
			String fileName=vo.getFileName();
			String filePath="d://temp/"+ fileName;
			
			System.out.println(fileName+"  : 이름");
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
		// 저장된 원본파일로부터 BufferedImage 객체를 생성합니다.
		BufferedImage srcImg = ImageIO.read(new File(filePath)); 
		// 썸네일의 너비와 높이 입니다.
		int dw = 250, dh = 150; 
		// 원본 이미지의 너비와 높이 입니다. 
		int ow = srcImg.getWidth(); int oh = srcImg.getHeight();
		// 원본 너비를 기준으로 하여 썸네일의 비율로 높이를 계산합니다.
		int nw = ow; int nh = (ow * dh) / dw; 
		// 계산된 높이가 원본보다 높다면 crop이 안되므로 
		// 원본 높이를 기준으로 썸네일의 비율로 너비를 계산합니다. 
		if(nh > oh) { nw = (oh * dw) / dh; nh = oh; } 
		// 계산된 크기로 원본이미지를 가운데에서 crop 합니다. 
		BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);
		// crop된 이미지로 썸네일을 생성합니다.
		BufferedImage destImg = Scalr.resize(cropImg, dw, dh);
		// 썸네일을 저장합니다. 이미지 이름 앞에 "THUMB_" 를 붙여 표시했습니다.
		String thumbName = PATH + "THUMB_" + fileName; File thumbFile = new File(thumbName);
		ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
		}
	
	
	
	

}
