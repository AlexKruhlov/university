package validator;

import ua.rafael.model.Subject;

public class SubjectValidator implements Validator<Subject> {

	@Override
	public void validate(final Subject subject) {
		checkForOnlyLetters(subject.getName());
	}

	private void checkForOnlyLetters(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isLetter(text.charAt(i))) {
				throw new RuntimeException("[Error]: Any symbol must be letter");
			}
		}
	}
}
