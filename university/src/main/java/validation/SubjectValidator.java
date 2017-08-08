package validation;

import static validation.ValidatorUtil.checkForSymbols;

import ua.rafael.model.Subject;

public class SubjectValidator implements Validator<Subject> {

	@Override
	public void validate(final Subject subject) {
		final String regexpPattern = "[a-zA-Z ]*+";
		if (!checkForSymbols(regexpPattern, subject.getName())) {
			throw new RuntimeException("[ERROR]: All symbols must be letters or underscore sign");
		}
	}
}
