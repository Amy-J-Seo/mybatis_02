package co.bambbang.prj.command;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.bambbang.prj.comm.Command;
import co.bambbang.prj.comm.SHA_256;


public class CyperText implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SHA_256 cyper = new SHA_256();
		
		String str = "Hello1234";
		String cyperText = null;
		try {
			cyperText = cyper.encrypt(str);
			//�� �� �̰Ÿ� ���� ��Ƽ� ���̺� Į���� ����ɶ��� ���� �����ϰ� �ҷ��ö��� ���� �ҷ��ͼ�
//			����ڰ� ��ǲ�� �־��� �� �ٽ� ��ũ��Ʈ ������ �װŸ� ��� ����� ��ȣ�� �ҷ��ͼ� ����.
//			�ֹι�ȣ�� ���ڸ��� �� ��ȣȭ�� �ؼ� �־���� �Ѵ�. �ּ� ��256�̻��� �˰����� ��� �Ѵ�.
			
			
			
			System.out.println(str +" : ����");
			System.out.println(cyperText +" : ��ȣ��");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return null;
	}

}
