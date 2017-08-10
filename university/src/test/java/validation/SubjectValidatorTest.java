package validation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Subject;
import ua.rafael.service.SubjectService;

import validation.Validator;

public class SubjectValidatorTest {
	private Validator<Subject> validator;
	SubjectService subjectService;
	Subject subjectWithNotNullId1;
	Subject subjectWithNullId1;
	Subject subjectWithNullId2;
	
	@Before
	public final void startUp() {
		SubjectSession session = new SubjectSession(
				MyBatisConnectionFactory.getSqlSessionFactory());
		subjectService = new SubjectService(session);
		subjectService.createTable();
		subjectWithNotNullId1 = new Subject("Mathematics");
		subjectWithNotNullId1.setId(1);
		subjectWithNullId1 = new Subject("Mathematics");
		subjectWithNullId2 = new Subject("Biology");
	}

	@Test
	public final void testValidateWithAllLetersSubject() {
		final Subject subject = new Subject("Mathematics");
		try {
			validator.validate(subject);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@Test
	public final void testValidateSubjectNameHasWhitespace() {
		final Subject subject = new Subject("Phisical training");
		try {
			validator.validate(subject);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@Test(expected = RuntimeException.class)
	public final void testValidateWithNumberInSubjectName() {
		final Subject subject = new Subject("Biology210");
		validator.validate(subject);
	}

	@Test(expected = RuntimeException.class)
	public void testValidateBySimilarObjectWithSimilarObject() {
		subjectService.insert(subjectWithNullId1);
		validator.validate(subjectWithNotNullId1);
	}

	@Test
	public final void testValidateBySimilarObjectWithoutSimilarObject() {
		subjectService.insert(subjectWithNullId1);
		try {
			validator.validate(subjectWithNullId2);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@After
	public final void finish() {
		subjectService.dropTable();
	}
}
