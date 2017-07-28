package validator;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.rafael.model.Subject;

public class SubjectValidatorTest {

	@Test
	public final void testValidateWithCorrectSubject() {
		final Validator<Subject> validator= new SubjectValidator();
		final Subject subject = new Subject("Mathematics");
		try{
			validator.validate(subject);
		}catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

}
