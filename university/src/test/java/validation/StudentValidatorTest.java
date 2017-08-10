package validation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.dao.StudentSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Student;
import ua.rafael.service.StudentService;
import validation.StudentValidator;
import validation.Validator;

public class StudentValidatorTest {

	private Validator<Student> validator;
	private StudentService studentService;
	private Student studentWithNullId1;
	private Student studentWithNotNullId1;
	private Student studentWithNullId2;

	@Before
	public final void startUp() {
		validator = new StudentValidator();
		StudentSession session = new StudentSession(
				MyBatisConnectionFactory.getSqlSessionFactory());
		studentService = new StudentService(session);
		studentService.createTable();
		studentWithNotNullId1 = new Student("Dave", "Joro");
		studentWithNotNullId1.setId(1);
		studentWithNullId1 = new Student("Dave", "Joro");
		studentWithNullId2 = new Student("Mike", "Franch");
	}

	@Test(expected = RuntimeException.class)
	public void testValidateBySimilarObjectWithSimilarObject() {
		studentService.insert(studentWithNullId1);
		validator.validate(studentWithNotNullId1);
	}

	@Test
	public final void testValidateBySimilarObjectWithoutSimilarObject() {
		studentService.insert(studentWithNullId1);
		try {
			validator.validate(studentWithNullId2);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@After
	public final void finish() {
		studentService.dropTable();
	}
}
