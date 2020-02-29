package pattern.exam;

import java.util.regex.Pattern;

/*
 * Password 체크
 * > 8글자 이상 & 대문자, 소문자, 특수문자, 숫자 모두 포함 
 */

public class PasswordCheck {
	public static boolean isPass(String str) {
		String pwreg="[A-Z]+[a-z]+[0-9]+[!@#$%^&*()_+\\\\-\\\\[\\\\]{};':\\\"\\\\\\\\|,.<>\\\\/?~`]+{8,}";
		return Pattern.matches(pwreg, str);
	}
	public static void main(String[] args) {
		System.out.println(isPass("qwerty"));			//false
    	System.out.println(isPass("qwerty123"));		//false
    	System.out.println(isPass("QWerty123)"));		//true
    	System.out.println(isPass("###"));				//false
    	System.out.println(isPass("qwertY000)"));		//true
    	System.out.println(isPass("QWERTy1$"));			//true
    	System.out.println(isPass("qqQ12&"));			//false
    	System.out.println(isPass("Abcd1234*"));		//true

	}

}