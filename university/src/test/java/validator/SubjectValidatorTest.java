package validator;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.rafael.model.Subject;

public class SubjectValidatorTest {

	@Test
	public final void testValidateWithAllLetersSubject() {
		final Validator<Subject> validator = new SubjectValidator();
		final Subject subject = new Subject(1,"Mathematics");
		try {
			validator.validate(subject);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}
	
	@Test
	public final void testValidateSubjectNameHasUnderscore() {
		final Validator<Subject> validator = new SubjectValidator();
		final Subject subject = new Subject(1,"Phisical_training");
		try {
			validator.validate(subject);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@Test(expected = RuntimeException.class)
	public final void testValidateWithNumberInSubjectName() {
		final Validator<Subject> validator = new SubjectValidator();
		final Subject subject = new Subject(1,"Biology210");
		validator.validate(subject);
	}

	@Test(expected = RuntimeException.class)
	public final void testValidateWithSpaceInSubjectName() {
		final Validator<Subject> validator = new SubjectValidator();
		final Subject subject = new Subject(1,"Phisical training");
		validator.validate(subject);
	}
}
