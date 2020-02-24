package pattern.exam;

import java.util.regex.Pattern;

public class PatternTest04 {

	public static void main(String[] args) {
		System.out.println(Pattern.matches("[0-9]+", "1234java"));	//false
		System.out.println(Pattern.matches("[0-9]+", "java"));		//false
		System.out.println(Pattern.matches("[0-9]+", "1234"));		//true
		System.out.println(Pattern.matches("[0-9]+", "1"));			//true
		System.out.println(Pattern.matches("[0-9]+", " "));			//false
		

		System.out.println(Pattern.matches("[0-9]?", "1234java"));	//false
		System.out.println(Pattern.matches("[0-9]?", "java"));		//false
		System.out.println(Pattern.matches("[0-9]?", "1234"));		//false
		System.out.println(Pattern.matches("[0-9]?", "1"));			//true
		System.out.println(Pattern.matches("[0-9]?", " "));			//false
	}

}
