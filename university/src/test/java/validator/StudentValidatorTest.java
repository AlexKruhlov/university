package validator;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import ua.rafael.model.Student;
import ua.rafael.util.JsonConverter;

public class StudentValidatorTest {

	private Validator<Student> validator = new StudentValidator();
	
	@Test
	public final void testValidateWithCorrectFullName() {
//		final String student = new Student();
//		validator.validate();
	}
}
