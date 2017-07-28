package validator;

import java.util.regex.Pattern;

import ua.rafael.model.Subject;

public class SubjectValidator implements Validator<Subject> {

	@Override
	public void validate(final Subject subject) {
		final String regexpPattern = "[a-zA-Z_]*+";
		if (!checkForSymbols(regexpPattern, subject.getName())) {
			throw new RuntimeException("[ERROR]: All symbols must be letters or underscore sign");
		}
	}

	private boolean checkForSymbols(final String regexpPattern, final String text) {
		Pattern pattern = Pattern.compile(regexpPattern);
		return pattern.matcher(text).matches();
	}
}
