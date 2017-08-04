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

public class AcademPerfomanceServiceTest {
	private SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	private AcademPerfomanceService academPerfomanceService
			= new AcademPerfomanceService(new AcademPerfomanceSession(sessionFactory));
	private List<AcademPerfomance> expected;
	private List<AcademPerfomance> actual;
	private StudentService studentService = new StudentService(new StudentSession(sessionFactory));
	private SubjectService subjectService = new SubjectService(new SubjectSession(sessionFactory));
	private MarkService markService = new MarkService(new MarkSession(sessionFactory));
	private AcademPerfomance academPerfomanceWithNullId1;
	private AcademPerfomance academPerfomanceWithNullId2;
	private AcademPerfomance academPerfomanceWithNotNullId1;
	private AcademPerfomance academPerfomanceWithNotNullId2;

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
		academPerfomanceService.createTable();
		academPerfomanceWithNullId1 = createAcadPerfomanceWithNullId(1, "Dave", "Joro", 1,
				"Mathematics", LocalDate.of(2017, 07, 29), 1, 1);
		academPerfomanceWithNullId2 = createAcadPerfomanceWithNullId(2, "Mike", "Franch", 2,
				"Chemistry", LocalDate.of(2017, 07, 30), 2, 2);
		academPerfomanceWithNotNullId1 = createAcadPerfomanceWithNotNullId(1, 1, "Dave", "Joro", 1,
				"Mathematics", LocalDate.of(2017, 07, 29), 1, 1);
		academPerfomanceWithNotNullId2
				= createAcadPerfomanceWithNotNullId(2, 2, "Mike", "Franch", 2,
						"Chemistry", LocalDate.of(2017, 07, 30), 2, 2);
	}

	@Test
	public void testInsert() {
		academPerfomanceService.insert(academPerfomanceWithNullId1);
		actual = academPerfomanceService.findAll();
		expected.add(academPerfomanceWithNotNullId1);
		assertEquals("Lists of academic perfomance items must be equls", expected, actual);
	}

	@Test
	public void testFindAll() {
		expected.add(academPerfomanceWithNotNullId1);
		expected.add(academPerfomanceWithNotNullId2);
		academPerfomanceService.insert(academPerfomanceWithNullId1);
		academPerfomanceService.insert(academPerfomanceWithNullId2);
		actual = academPerfomanceService.findAll();
		assertEquals("Lists of academic perfomance items must be equls",expected, actual);
	}
	
	@Test
	public void testFindById() {
		final AcademPerfomance expected = academPerfomanceWithNotNullId2;
		academPerfomanceService.insert(academPerfomanceWithNullId1);
		academPerfomanceService.insert(academPerfomanceWithNullId2);
		final AcademPerfomance actual = academPerfomanceService.findById(2);
		assertEquals(expected, actual);
	}

	@Test
	public final void testFindByStudentAndSubject() {
		expected.add(academPerfomanceWithNotNullId1);
		academPerfomanceService.insert(academPerfomanceWithNullId1);
		academPerfomanceService.insert(academPerfomanceWithNullId2);
		final Student student = new Student("Dave", "Joro");
		student.setId(1);
		final Subject subject = new Subject("Mathematics");
		subject.setId(1);
		actual = academPerfomanceService.findBy(student, subject);
		assertEquals("Lists of academic perfomance items must be equls",expected, actual);
	}

	@Test
	public final void testFindByStudentAndDate() {
		expected.add(academPerfomanceWithNotNullId2);
		academPerfomanceService.insert(academPerfomanceWithNullId1);
		academPerfomanceService.insert(academPerfomanceWithNullId2);
		final Student student = new Student("Mike", "Franch");
		student.setId(2);
		actual = academPerfomanceService.findBy(student, of(2017, 7, 30));
		assertEquals("Lists of academic perfomance items must be equls",expected, actual);
	}

	@Test
	public final void testCountAverageMarkByStudentAndSubject() {
		final double expected = 1.5;
		final AcademPerfomance academPerfomanceWithNullId3
				= createAcadPerfomanceWithNullId(1, "Dave", "Joro", 1,
						"Mathematics", LocalDate.of(2017, 07, 30), 2, 2);
		academPerfomanceService.insert(academPerfomanceWithNullId1);
		academPerfomanceService.insert(academPerfomanceWithNullId2);
		academPerfomanceService.insert(academPerfomanceWithNullId3);
		final Student student = new Student("Dave", "Joro");
		student.setId(1);
		final Subject subject = new Subject("Mathematics");
		subject.setId(1);
		final double actual = academPerfomanceService.countAverageBy(student, subject);
		assertEquals("Nubers should have equal values",expected, actual, 0.01);
	}

	@Test
	public void testDelete() {
		expected.add(academPerfomanceWithNotNullId1);
		expected.add(academPerfomanceWithNotNullId2);
		academPerfomanceService.insert(academPerfomanceWithNullId1);
		academPerfomanceService.insert(academPerfomanceWithNullId2);
		actual = academPerfomanceService.findAll();
		assertEquals(expected, actual);
		expected.remove(0);
		academPerfomanceService.delete(1);
		actual = academPerfomanceService.findAll();
		assertEquals("Lists of academic perfomance items must be equls",expected, actual);
	}

	// @Test
	// public final void testUpdate() {
	// final List<AcademPerfomance> expected = new ArrayList<>();
	// List<AcademPerfomance> actual = null;
	// expected.add(academPerfomance1);
	// expected.add(academPerfomance2);
	// academPerfomanceService.insert(academPerfomance1);
	// academPerfomanceService.insert(academPerfomance2);
	// actual = academPerfomanceService.selectAll();
	// assertEquals(expected, actual);
	// final AcademPerfomance academPerfomanceToUpdate
	// = new AcademPerfomance(new Student(3, "Sindey", "Grant"), new Subject(3,
	// "Biology"),
	// LocalDate.of(2017, 07, 30), new Mark(3, 3));
	// expected.set(0, academPerfomanceToUpdate);
	// academPerfomanceService.update(academPerfomanceToUpdate);
	// actual = academPerfomanceService.selectAll();
	// assertEquals(expected, actual);
	// }

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
