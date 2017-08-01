package validator;

import java.util.regex.Pattern;

public class ValidatorUtil {
	
	public static boolean checkForSymbols(final String regexpPattern, final String text) {
		Pattern pattern = Pattern.compile(regexpPattern);
		return pattern.matcher(text).matches();
	}
}
