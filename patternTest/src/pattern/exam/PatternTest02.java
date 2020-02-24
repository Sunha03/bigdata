package pattern.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest02 {

	public static void main(String[] args) {
		//String str = "java programmaingm";
		//String patternStr = "a|m|g";			//1. | : or (a/m/g로 시작하는 문자열)
		//String patternStr = "[amg]";			//2. 1번과 동일 (a/m/g로 시작하는 문자열)
		//String patternStr = "[amg][ma]";		//3. 2글자에 대해 or 조건 적용
												//(첫번째 글자 : a/m/g or 두번째 글자 : m/a)
		//String patternStr = "[c-j]";			//4. c~j (O)
		//String patternStr = "[C-J]";			//5. A~B (O)
		//String patternStr = "[A-Bc-j]";		//6. A~B, c~j (O)
		
		String str = "ja1111aCva--@@-@@@@- 한글 --@@@@-- progra44568EmgFmiJng";
		//String patternStr = "[C-Jc-j]";		//7. C~J, c~j (O)
		//String patternStr = "[4-8]";			//8. 4~8 (O)
		//String patternStr = "[^4-8]";			//9. [^] : 부정 (4~8 (X))
		//String patternStr = "[^c-j]";			//10. c~j (X)
		//String patternStr = "[A-Za-z0-9]";	//11. 영문자, 숫자 (O)
		//String patternStr = "[^A-Za-z0-9]";	//12. 영문자, 숫자 (X)
		String patternStr = "[가-힣]";			//13. 한글만 (O)
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
