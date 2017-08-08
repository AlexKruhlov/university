package ua.rafael.service.validation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.dao.StudentSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Student;
import ua.rafael.service.StudentService;

public class StudentServiceValidatorTest {
	private ServiceValidator<Student> studentServiceValidator;
	private StudentService studentService;
	private Student studentWithNullId1;
	private Student studentWithNotNullId1;
	private Student studentWithNullId2;

	@Before
	public final void startUp() {
		studentServiceValidator = new StudentServiceValidator();
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
		studentServiceValidator.validateBySimilarObject(studentWithNotNullId1);
	}

	@Test
	public final void testValidateBySimilarObjectWithoutSimilarObject() {
		studentService.insert(studentWithNullId1);
		try {
			studentServiceValidator.validateBySimilarObject(studentWithNullId2);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@After
	public final void finish() {
		studentService.dropTable();
	}
}
