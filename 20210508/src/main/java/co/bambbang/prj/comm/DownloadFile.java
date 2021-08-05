package co.bambbang.prj.comm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DownloadFile {
	private String path;//������ ���� ��� �ִ� ������ ���� �ּ�
	private String orgFileName; //���� ������ �̸�
	private String downFileName; //���� �ٿ�ε� �� ������ �̸�
	
	public DownloadFile(String path, String orgFileName, String downFileName) {
		this.path = path;
		this.orgFileName = orgFileName;
		this.downFileName = downFileName;		
	}
	
	public boolean isFileDown() { //�����ϸ� false, �����ϸ� true
		boolean bool = true;
		File file = new File(path+File.separator+ downFileName);
		FileInputStream in;
		try {
			in = new FileInputStream(file);
			FileOutputStream outFile = new FileOutputStream("d://download//" + orgFileName);
			
			byte b [] = new byte[4096];
			int data =0;
			while((data = in.read(b,0,b.length)) !=-1) {
				outFile.write(b,0, data);
			}
			outFile.flush();
			in.close();
			outFile.close();
			bool=false;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return bool;
		
	}
}
