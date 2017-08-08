package validation;

import static validation.ValidatorUtil.checkForSymbols;

import ua.rafael.model.Student;

public class StudentValidator implements Validator<Student> {

	@Override
	public void validate(final Student student) {
		final String symbolsForHumanName = "[a-zA-Z-]*+";
		if (!checkForSymbols(symbolsForHumanName, student.getFirstName())) {
			throw new RuntimeException("Incorrect symbol for first name was found");
		}
		if (!checkForSymbols(symbolsForHumanName, student.getLastName())) {
			throw new RuntimeException("Incorrect symbol for last name was found");
		}
	}
}
