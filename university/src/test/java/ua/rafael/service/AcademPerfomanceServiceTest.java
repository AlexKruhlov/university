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
	private AcademPerfomanceService academPerfomanceService = new AcademPerfomanceService(
			new AcademPerfomanceSession(sessionFactory));
	private StudentService studentService = new StudentService(new StudentSession(sessionFactory));
	private SubjectService subjectService = new SubjectService(new SubjectSession(sessionFactory));
	private MarkService markService = new MarkService(new MarkSession(sessionFactory));
	private AcademPerfomance academPerfomance1;
	private AcademPerfomance academPerfomance2;
	private AcademPerfomance academPerfomance3;

	@Before
	public final void startUp() {
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
		
		
		academPerfomance1 = new AcademPerfomance(new Student("Dave", "Joro"),
				new Subject("Mathematics"),
				LocalDate.of(2017, 07, 30), new Mark(1));
		academPerfomance2 = new AcademPerfomance(new Student("Mike", "Franch"),
				new Subject("Chemistry"),
				LocalDate.of(2017, 07, 29), new Mark(2));
		academPerfomance3 = new AcademPerfomance(new Student("Sindey", "Grant"),
				new Subject("Biology"),
				LocalDate.of(2017, 07, 30), new Mark(3));
	}

	@Test
	public void testInsert() {
		final List<AcademPerfomance> expected = new ArrayList<>();
		List<AcademPerfomance> actual = null;
		academPerfomanceService.insert(academPerfomance1);
		actual = academPerfomanceService.selectAll();
		expected.add(academPerfomance1);
		assertEquals(expected, actual);
		expected.add(academPerfomance2);
		academPerfomanceService.insert(academPerfomance2);
		actual = academPerfomanceService.selectAll();
		assertEquals(expected, actual);
	}

	@Test
	public void testSelectAll() {
		final List<AcademPerfomance> expected = new ArrayList<>();
		expected.add(academPerfomance1);
		expected.add(academPerfomance2);
		expected.add(academPerfomance3);
		academPerfomanceService.insert(academPerfomance1);
		academPerfomanceService.insert(academPerfomance2);
		academPerfomanceService.insert(academPerfomance3);
		final List<AcademPerfomance> actual = academPerfomanceService.selectAll();
		assertEquals(expected, actual);
	}

	@Test
	public final void testSelectByStudentAndSubject() {
		academPerfomance3 = new AcademPerfomance(new Student("Dave", "Joro"),
				new Subject("Mathematics"),
				LocalDate.of(2017, 07, 31), new Mark(3));
		final List<AcademPerfomance> expected = new ArrayList<>();
		expected.add(academPerfomance1);
		expected.add(academPerfomance3);
		academPerfomanceService.insert(academPerfomance1);
		academPerfomanceService.insert(academPerfomance2);
		academPerfomanceService.insert(academPerfomance3);
		final List<AcademPerfomance> actual = academPerfomanceService.selectBy(
				new Student("Dave", "Joro"), new Subject("Mathematics"));
		assertEquals(expected, actual);
	}

	@Test
	public final void testSelectByStudentAndDate() {
		academPerfomance2 = new AcademPerfomance(new Student("Dave", "Joro"),
				new Subject("Mathematics"),
				LocalDate.of(2017, 07, 29), new Mark(1));
		academPerfomance3 = new AcademPerfomance(new Student("Dave", "Joro"),
				new Subject("Chemistry"),
				LocalDate.of(2017, 07, 30), new Mark(3));
		final List<AcademPerfomance> expected = new ArrayList<>();
		expected.add(academPerfomance3);
		expected.add(academPerfomance1);
		academPerfomanceService.insert(academPerfomance1);
		academPerfomanceService.insert(academPerfomance2);
		academPerfomanceService.insert(academPerfomance3);
		final List<AcademPerfomance> actual = academPerfomanceService.selectBy(
				new Student("Dave", "Joro"), of(2017, 7, 30));
		assertEquals(expected, actual);
	}

	@Test
	public final void testSelectAverageMarkByStudentAndSubject() {
		final double expected = 1.5;
		academPerfomanceService.insert(academPerfomance1);
		academPerfomanceService.insert(academPerfomance2);
		academPerfomanceService.insert(academPerfomance3);
		academPerfomanceService.insert(new AcademPerfomance(new Student("Dave", "Joro"),
				new Subject("Mathematics"),
				LocalDate.of(2017, 07, 31),
				new Mark(2)));
		final double actual = academPerfomanceService.countAverageBy(new Student("Dave", "Joro"),
				new Subject("Mathematics"));
		assertEquals(expected, actual, 0.01);
	}

	@Test
	public void testDelete() {
		final List<AcademPerfomance> expected = new ArrayList<>();
		List<AcademPerfomance> actual = null;
		expected.add(academPerfomance1);
		expected.add(academPerfomance2);
		expected.add(academPerfomance3);
		academPerfomanceService.insert(academPerfomance1);
		academPerfomanceService.insert(academPerfomance2);
		academPerfomanceService.insert(academPerfomance3);
		actual = academPerfomanceService.selectAll();
		assertEquals(expected, actual);
		expected.remove(0);
		academPerfomanceService.delete(1);
		actual = academPerfomanceService.selectAll();
		assertEquals(expected, actual);
		expected.remove(0);
		academPerfomanceService.delete(2);
		actual = academPerfomanceService.selectAll();
		assertEquals(expected, actual);
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
	
}
