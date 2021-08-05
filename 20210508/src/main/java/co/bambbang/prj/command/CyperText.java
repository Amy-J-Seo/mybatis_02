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
			//이 때 이거를 보에 담아서 테이블 칼럼에 저장될때도 저걸 저장하고 불러올때도 저걸 불러와서
//			사용자가 인풋을 넣었을 때 다시 인크립트 돌려서 그거를 디비에 저장된 암호를 불러와서 비교함.
//			주민번호도 뒷자리를 꼭 암호화를 해서 넣어줘야 한다. 최소 샤256이상의 알고리즘을 써야 한다.
			
			
			
			System.out.println(str +" : 원문");
			System.out.println(cyperText +" : 암호문");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return null;
	}

}
