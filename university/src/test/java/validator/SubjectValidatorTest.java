package validator;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.rafael.model.Subject;

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
	public final void testValidateSubjectNameHasUnderscore() {
		final Validator<Subject> validator = new SubjectValidator();
		final Subject subject = new Subject("Phisical_training");
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

	@Test(expected = RuntimeException.class)
	public final void testValidateWithSpaceInSubjectName() {
		final Validator<Subject> validator = new SubjectValidator();
		final Subject subject = new Subject("Phisical training");
		validator.validate(subject);
	}
}
