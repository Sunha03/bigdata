package pattern.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest01 {

	public static void main(String[] args) {
		//String str = "JAVA, H1 --- java";
		String str = "$100. .한 $20.0";
		//String patternStr = "java";			//1. 정확히 일치
		//String patternStr = "^java";			//2. ^ 뒤의 문자열로 시작하는지
		//String patternStr = "java$";			//3. $ 앞의 문자열로 종료하는지
		//String patternStr = "^\\$";			//4. '$'로 시작하는지
												//	 > 패턴에서 사용하는 기호는 일반문자열로 인식 (X)
												//	 >> 앞에 '\\' 붙여줘야 함
		//String patternStr = "\\$$";			//5. '$'로 끝나는지
		//String patternStr = "..";				//6. . : 글자 1개
		//String patternStr = "\\.";				//7. '.'이 포함된 문자열
		String patternStr = "\\..\\.";			//2. .'?'. 형태의 문자열
		equalsPattern(str, patternStr);
	}

	public static void equalsPattern(String str, String patternStr) {
		//1. 패턴 인식
		Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
		
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
