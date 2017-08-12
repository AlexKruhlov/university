package ua.rafael.service;

import static java.time.LocalDate.of;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.dao.PogressSession;
import ua.rafael.dao.MarkSession;
import ua.rafael.dao.StudentSession;
import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Progress;
import ua.rafael.model.Mark;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;
import ua.rafael.service.ProgressService;
import ua.rafael.service.MarkService;
import ua.rafael.service.StudentService;
import ua.rafael.service.SubjectService;

public class ProgressServiceTest {
	private SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	private ProgressService progressService = new ProgressService(
			new PogressSession(sessionFactory));
	private List<Progress> expected;
	private List<Progress> actual;
	private StudentService studentService = new StudentService(new StudentSession(sessionFactory));
	private SubjectService subjectService = new SubjectService(new SubjectSession(sessionFactory));
	private MarkService markService = new MarkService(new MarkSession(sessionFactory));
	private Progress progressWithNullId1;
	private Progress progressWithNullId2;
	private Progress progressWithNotNullId1;
	private Progress progressWithNotNullId2;

	@Before
	public final void startUp() {
		expected = new ArrayList<>();
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
		progressService.createTable();
		progressWithNullId1 = createProgressWithNullId(1, "Dave", "Joro", 1,
				"Mathematics", LocalDate.of(2017, 07, 29), 1, 1);
		progressWithNullId2 = createProgressWithNullId(2, "Mike", "Franch", 2,
				"Chemistry", LocalDate.of(2017, 07, 30), 2, 2);
		progressWithNotNullId1 = createProgressWithNotNullId(1, 1, "Dave", "Joro", 1,
				"Mathematics", LocalDate.of(2017, 07, 29), 1, 1);
		progressWithNotNullId2 = createProgressWithNotNullId(2, 2, "Mike", "Franch",
				2,
				"Chemistry", LocalDate.of(2017, 07, 30), 2, 2);
	}

	@Test
	public void testInsert() {
		progressService.insert(progressWithNullId1);
		actual = progressService.findAll();
		expected.add(progressWithNotNullId1);
		assertEquals("Lists of progress items must be equls", expected, actual);
	}

	@Test
	public void testFindAll() {
		expected.add(progressWithNotNullId1);
		expected.add(progressWithNotNullId2);
		progressService.insert(progressWithNullId1);
		progressService.insert(progressWithNullId2);
		actual = progressService.findAll();
		assertEquals("Lists of progress items must be equls", expected, actual);
	}

	@Test
	public void testFindById() {
		final Progress expected = progressWithNotNullId2;
		progressService.insert(progressWithNullId1);
		progressService.insert(progressWithNullId2);
		final Progress actual = progressService.findById(2);
		assertEquals(expected, actual);
	}

	@Test
	public final void testFindByStudentAndSubject() {
		expected.add(progressWithNotNullId1);
		progressService.insert(progressWithNullId1);
		progressService.insert(progressWithNullId2);
		final Student student = new Student("Dave", "Joro");
		student.setId(1);
		final Subject subject = new Subject("Mathematics");
		subject.setId(1);
		actual = progressService.findBy(student, subject);
		assertEquals("Lists of progress items must be equls", expected, actual);
	}

	@Test
	public final void testFindByStudentAndDate() {
		expected.add(progressWithNotNullId2);
		progressService.insert(progressWithNullId1);
		progressService.insert(progressWithNullId2);
		final Student student = new Student("Mike", "Franch");
		student.setId(2);
		actual = progressService.findBy(student, of(2017, 7, 30));
		assertEquals("Lists of progress items must be equls", expected, actual);
	}

	@Test
	public final void testFindByStudentAndSubjectAndDate() {
		final Progress expected = progressWithNotNullId2;
		progressService.insert(progressWithNullId1);
		progressService.insert(progressWithNullId2);
		final Student student = new Student("Mike", "Franch");
		student.setId(2);
		final Subject subject = new Subject("Chemistry");
		subject.setId(2);
		final LocalDate date = LocalDate.of(2017, 7, 30);
		final Progress actual = progressService.findBy(student, subject, date);
		assertEquals("Academic perfomance items must be equal", expected, actual);
	}

	@Test
	public final void testCountAverageMarkByStudentAndSubject() {
		final double expected = 1.5;
		final Progress progressWithNullId3 = createProgressWithNullId(1,
				"Dave", "Joro", 1,
				"Mathematics", LocalDate.of(2017, 07, 30), 2, 2);
		progressService.insert(progressWithNullId1);
		progressService.insert(progressWithNullId2);
		progressService.insert(progressWithNullId3);
		final Student student = new Student("Dave", "Joro");
		student.setId(1);
		final Subject subject = new Subject("Mathematics");
		subject.setId(1);
		final double actual = progressService.countAverageBy(student, subject);
		assertEquals("Nubers should have equal values", expected, actual, 0.01);
	}

	@Test
	public void testDelete() {
		expected.add(progressWithNotNullId1);
		expected.add(progressWithNotNullId2);
		progressService.insert(progressWithNullId1);
		progressService.insert(progressWithNullId2);
		actual = progressService.findAll();
		assertEquals(expected, actual);
		expected.remove(0);
		progressService.delete(1);
		actual = progressService.findAll();
		assertEquals("Lists of progress items must be equls", expected, actual);
	}

	@Test
	public final void testUpdate() {
		progressWithNotNullId2.setId(1);
		expected.add(progressWithNotNullId2);
		progressService.insert(progressWithNullId1);
		progressService.update(1, progressWithNullId2);
		actual = progressService.findAll();
		assertEquals(expected, actual);
	}

	@After
	public final void finish() {
		progressService.dropTable();
		studentService.dropTable();
		subjectService.dropTable();
		markService.dropTable();
	}

	private Progress createProgressWithNullId(final long studentId,
			final String firstName, final String lastName, final long subjectId,
			final String subjectName, final LocalDate date, final long markId,
			final int markValue) {
		final Student student = new Student(firstName, lastName);
		student.setId(studentId);
		final Subject subject = new Subject(subjectName);
		subject.setId(subjectId);
		final Mark mark = new Mark(markValue);
		mark.setId(markId);
		return new Progress(student, subject, date, mark);
	}

	private Progress createProgressWithNotNullId(final long id, final long studentId,
			final String firstName, final String lastName, final long subjectId,
			final String subjectName, final LocalDate date, final long markId,
			final int markValue) {
		Progress progress = createProgressWithNullId(studentId, firstName,
				lastName, subjectId, subjectName, date, markId, markValue);
		progress.setId(id);
		return progress;
	}
}
