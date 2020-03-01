package pattern.exam;

import java.util.regex.Pattern;

/*
 * Password 체크
 * > 8글자 이상 & 대문자, 소문자, 특수문자, 숫자 모두 포함 
 */

public class PasswordCheck {
	public static boolean isUpper(String str) {			//대문자 여부
		String pwreg=".*[A-Z]+.*";
		return Pattern.matches(pwreg, str);
	}
	public static boolean isLower(String str) {			//소문자 여부
		String pwreg=".*[a-z]+.*";
		return Pattern.matches(pwreg, str);
	}
	public static boolean isNumber(String str) {		//숫자 여부
		String pwreg=".*[0-9]+.*";
		return Pattern.matches(pwreg, str);
	}
	public static boolean isSpecial(String str) {		//특수문자 여부
		String pwreg=".*[!@#$%^&*_+;':,.<>?~`\\{\\}\\(\\)\\[\\]]+.*";
		return Pattern.matches(pwreg, str);
	}
	public static boolean isEightOrMore(String str) {	//8글자 이상
		String pwreg=".{8,}";
		return Pattern.matches(pwreg, str);
	}
	public static void main(String[] args) {
		String pw1 = "qwerty";			//false
		String pw2 = "qwery123";		//false
		String pw3 = "QWerty123";		//false
		String pw4 = "$00Abc";			//false
		String pw5 = "qwertY000#";		//true
		String pw6 = "qWERTy12~";		//true
		String pw7 = "{Qwer1234}";		//true
		String pw8 = "Abcd'1234";		//true


		//System.out.println(isUpper(pw1) +" "+ isLower(pw1) +" "+ isNumber(pw1) +" "+ isSpecial(pw1) +" "+ isEightOrMore(pw1));
		System.out.println(isUpper(pw1) && isLower(pw1) && isNumber(pw1) && isSpecial(pw1) && isEightOrMore(pw1));
		//System.out.println(isUpper(pw2) +" "+ isLower(pw2) +" "+ isNumber(pw2) +" "+ isSpecial(pw2) +" "+ isEightOrMore(pw2));
		System.out.println(isUpper(pw2) && isLower(pw2) && isNumber(pw2) && isSpecial(pw2) && isEightOrMore(pw2));
		//System.out.println(isUpper(pw3) +" "+ isLower(pw3) +" "+ isNumber(pw3) +" "+ isSpecial(pw3) +" "+ isEightOrMore(pw3));
		System.out.println(isUpper(pw3) && isLower(pw3) && isNumber(pw3) && isSpecial(pw3) && isEightOrMore(pw3));
		//System.out.println(isUpper(pw4) +" "+ isLower(pw4) +" "+ isNumber(pw4) +" "+ isSpecial(pw4) +" "+ isEightOrMore(pw4));
		System.out.println(isUpper(pw4) && isLower(pw4) && isNumber(pw4) && isSpecial(pw4) && isEightOrMore(pw4));
		//System.out.println(isUpper(pw5) +" "+ isLower(pw5) +" "+ isNumber(pw5) +" "+ isSpecial(pw5) +" "+ isEightOrMore(pw5));
		System.out.println(isUpper(pw5) && isLower(pw5) && isNumber(pw5) && isSpecial(pw5) && isEightOrMore(pw5));
		//System.out.println(isUpper(pw6) +" "+ isLower(pw6) +" "+ isNumber(pw6) +" "+ isSpecial(pw6) +" "+ isEightOrMore(pw6));
		System.out.println(isUpper(pw6) && isLower(pw6) && isNumber(pw6) && isSpecial(pw6) && isEightOrMore(pw6));
		//System.out.println(isUpper(pw7) +" "+ isLower(pw7) +" "+ isNumber(pw7) +" "+ isSpecial(pw7) +" "+ isEightOrMore(pw7));
		System.out.println(isUpper(pw7) && isLower(pw7) && isNumber(pw7) && isSpecial(pw7) && isEightOrMore(pw7));
		//System.out.println(isUpper(pw8) +" "+ isLower(pw8) +" "+ isNumber(pw8) +" "+ isSpecial(pw8) +" "+ isEightOrMore(pw8));
		System.out.println(isUpper(pw8) && isLower(pw8) && isNumber(pw8) && isSpecial(pw8) && isEightOrMore(pw8));
	}

}