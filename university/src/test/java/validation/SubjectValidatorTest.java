package validation;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.rafael.model.Subject;
import validation.SubjectValidator;
import validation.Validator;

public class SubjectValidatorTest {

	@Test
	public final void testValidateWithAllLetersSubject() {
		final Validator<Subject> validator = new SubjectValidator();
		final Subject subject = new Subject("Mathematics");
		try {
			validator.validate(subject);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}
	
	@Test
	public final void testValidateSubjectNameHasWhitespace() {
		final Validator<Subject> validator = new SubjectValidator();
		final Subject subject = new Subject("Phisical training");
		try {
			validator.validate(subject);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@Test(expected = RuntimeException.class)
	public final void testValidateWithNumberInSubjectName() {
		final Validator<Subject> validator = new SubjectValidator();
		final Subject subject = new Subject("Biology210");
		validator.validate(subject);
	}
}
