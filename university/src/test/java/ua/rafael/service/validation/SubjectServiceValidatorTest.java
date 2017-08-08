package ua.rafael.service.validation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Subject;
import ua.rafael.service.SubjectService;
import validation.SubjectValidator;
import validation.Validator;

public class SubjectServiceValidatorTest {
	private ServiceValidator<Subject> subjectServiceValidator;
	private SubjectService subjectService;
	private Subject subjectWithNullId1;
	private Subject subjectWithNotNullId1;
	private Subject subjectWithNullId2;

	@Before
	public final void startUp() {
		subjectServiceValidator = new SubjectServiceValidator();
		SubjectSession session = new SubjectSession(
				MyBatisConnectionFactory.getSqlSessionFactory());
		subjectService = new SubjectService(session);
		subjectService.createTable();
		subjectWithNotNullId1 = new Subject("Mathematics");
		subjectWithNotNullId1.setId(1);
		subjectWithNullId1 = new Subject("Mathematics");
		subjectWithNullId2 = new Subject("Biology");
	}

	@Test(expected = RuntimeException.class)
	public void testValidateBySimilarObjectWithSimilarObject() {
		subjectService.insert(subjectWithNullId1);
		subjectServiceValidator.validateBySimilarObject(subjectWithNotNullId1);
	}

	@Test
	public final void testValidateBySimilarObjectWithoutSimilarObject() {
		subjectService.insert(subjectWithNullId1);
		try {
			subjectServiceValidator.validateBySimilarObject(subjectWithNullId2);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@After
	public final void finish() {
		subjectService.dropTable();
	}
}
