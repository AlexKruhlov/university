package ua.rafael.service.validation;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.dao.AcademPerfomanceSession;
import ua.rafael.dao.MarkSession;
import ua.rafael.dao.StudentSession;
import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Mark;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;
import ua.rafael.service.AcademPerfomanceService;
import ua.rafael.service.MarkService;
import ua.rafael.service.StudentService;
import ua.rafael.service.SubjectService;

public class AcademPerfomanceServiceValidatorTest {
	private SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	private AcademPerfomanceService academPerfomanceService = new AcademPerfomanceService(
			new AcademPerfomanceSession(sessionFactory));
	private AcademPerfomanceServiceValidator serviceValidator;
	private StudentService studentService = new StudentService(new StudentSession(sessionFactory));
	private SubjectService subjectService = new SubjectService(new SubjectSession(sessionFactory));
	private MarkService markService = new MarkService(new MarkSession(sessionFactory));
	private AcademPerfomance academPerfomanceWithNullId1;
	private AcademPerfomance academPerfomanceWithNullId2;
	private AcademPerfomance academPerfomanceWithNotNullId1;
	private AcademPerfomance academPerfomanceWithNotNullId2;

	@Before
	public final void startUp() {
		serviceValidator = new AcademPerfomanceServiceValidator();
		subjectService.createTable();
		subjectService.insert(new Subject("Mathematics"));
		subjectService.insert(new Subject("Chemistry"));
		subjectService.insert(new Subject("Biology"));
		studentService.createTable();
		studentService.insert(new Student("Dave", "Joro"));
		studentService.insert(new Student("Mike", "Franch"));
		studentService.insert(new Student("Sindey", "Grant"));
		markService.createTable();
		markService.insert(new Mark(1));
		markService.insert(new Mark(2));
		markService.insert(new Mark(3));
		academPerfomanceService.createTable();
		academPerfomanceWithNullId1 = createAcadPerfomanceWithNullId(1, "Dave", "Joro", 1,
				"Mathematics", LocalDate.of(2017, 07, 29), 1, 1);
		academPerfomanceWithNullId2 = createAcadPerfomanceWithNullId(2, "Mike", "Franch", 2,
				"Chemistry", LocalDate.of(2017, 07, 30), 2, 2);
		academPerfomanceWithNotNullId1 = createAcadPerfomanceWithNotNullId(1, 1, "Dave", "Joro", 1,
				"Mathematics", LocalDate.of(2017, 07, 29), 1, 1);
		academPerfomanceWithNotNullId2 = createAcadPerfomanceWithNotNullId(2, 2, "Mike", "Franch",
				2, "Chemistry", LocalDate.of(2017, 07, 30), 2, 2);
	}

	@Test(expected = RuntimeException.class)
	public void testValidateBySimilarObject() {
		academPerfomanceService.insert(academPerfomanceWithNullId1);
		serviceValidator.validateBySimilarObject(academPerfomanceWithNotNullId1);
	}

	@Test
	public final void testValidateBySimilarObjectWithoutSimilarObject() {
		academPerfomanceService.insert(academPerfomanceWithNullId1);
		try {
			serviceValidator.validateBySimilarObject(academPerfomanceWithNullId2);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@After
	public final void finish() {
		academPerfomanceService.dropTable();
		studentService.dropTable();
		subjectService.dropTable();
		markService.dropTable();
	}

	private AcademPerfomance createAcadPerfomanceWithNullId(final long studentId,
			final String firstName, final String lastName, final long subjectId,
			final String subjectName, final LocalDate date, final long markId,
			final int markValue) {
		final Student student = new Student(firstName, lastName);
		student.setId(studentId);
		final Subject subject = new Subject(subjectName);
		subject.setId(subjectId);
		final Mark mark = new Mark(markValue);
		mark.setId(markId);
		return new AcademPerfomance(student, subject, date, mark);
	}

	private AcademPerfomance createAcadPerfomanceWithNotNullId(final long id, final long studentId,
			final String firstName, final String lastName, final long subjectId,
			final String subjectName, final LocalDate date, final long markId,
			final int markValue) {
		AcademPerfomance academPerfomance = createAcadPerfomanceWithNullId(studentId, firstName,
				lastName, subjectId, subjectName, date, markId, markValue);
		academPerfomance.setId(id);
		return academPerfomance;
	}
}
