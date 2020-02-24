package pattern.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest03 {

	public static void main(String[] args) {
		//String str = "-@-ja1- ja1111aCva--@@-@@@@- 한글 --@@@@-- progra44568EmgFmiJng";
		//String patternStr = ".*";			//1. * 앞의 패턴문자가 0 or 1 or 여러 개 있을 때 
		//String patternStr = "-@+-";		//2. -@...@- : 안에 @가 1개 or 여러개 
		//String patternStr = "-@?-";		//3. -@- / -- : 안에 @가 0개 or 1개
		//String patternStr = "[^ ]";		//4. ' ' (X)
		//String patternStr = ".{5}";		//5. 5글자씩 끊어서
		
		String str = "a m v 4 7 9 amJAVA _java aaaxl  programming and spring , hadoop";
		//String patternStr = "[amv]{1,3}";	//6. a, m, v가 1회, 2회, 3회인 문자(=a,m,v,aa,ma,...,vvv)
		//String patternStr = "[a-z]{1,3}";	//7. 3글자 이상
		//String patternStr = "\\W";		//8. 대문자, 소문자, 숫자 모두 (X) (=[^A-Za-z0-9])
		//String patternStr = "\\w";		//9. 대문자, 소문자, 숫자 모두 (O) (=[A-Za-z0-9])
		//String patternStr = "\\d";		//10. 숫자만 (O)
		String patternStr = "\\D";			//11. 숫자 모두 (X)
		equalsPattern(str, patternStr);
	}

	public static void equalsPattern(String str, String patternStr) {
		//1. 패턴 인식
		Pattern pattern = Pattern.compile(patternStr/*, Pattern.CASE_INSENSITIVE*/);
		
		//2. 패턴 적용하여 문자열을 관리
		Matcher m = pattern.matcher(str);
		
		/*System.out.println(m.find());
		System.out.println(m.start());
		System.out.println(m.end());
		System.out.println(m.group());*/
		
		while(m.find()) {
			System.out.println(m.group());
			System.out.println(m.start() + " : " + (m.end() - 1));
		}
	}
}
