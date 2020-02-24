package pattern.exam;

import java.util.regex.Pattern;

public class EmailCheck {
	public static void main(String[] args) {
		//x{n}=>x를 n번 반복한 문자를 찾는다는 의미로 해석
		String emailReg="";
		String[] user = {"heaves@hanmail,net",		//false
						"heaves@hanmail.net",		//true
						"테스트heaves@hanmail.net",	//false
						"sc.com@hanmail.net",		//true
						",heaves@hanmail.net",		//false
						"@hanmail.net",				//false
						"heaves@hanmail.co.kr"};	//true
		//user에 입력된 email의 형식이 맞는지 true|false로 출력할 수 있도록 작업	
		for(int i=0;i<user.length;i++) {
			//System.out.println(Pattern.matches("[A-z0-9\\.]+@[A-z0-9\\.]+[A-z0-9]+", user[i]));
			System.out.println(Pattern.matches("^[A-z]+\\.?[A-z0-9]+@[A-z]+(\\.[A-z]+){1,2}$", user[i]));
		}
	}

}
