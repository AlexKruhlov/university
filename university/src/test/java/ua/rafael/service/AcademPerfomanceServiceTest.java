package ua.rafael.service;

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

	@Before
	public final void startUp() {
		subjectService.createTable();
		subjectService.insert(new Subject(1, "Mathematics"));
		subjectService.insert(new Subject(2, "Chemistry"));
		subjectService.insert(new Subject(3, "Biology"));
		studentService.createTable();
		studentService.insert(new Student(1, "Dave", "Joro"));
		studentService.insert(new Student(2, "Mike", "Franch"));
		studentService.insert(new Student(3, "Sindey", "Grant"));
		markService.createTable();
		markService.insert(new Mark(1, 1));
		markService.insert(new Mark(2, 2));
		markService.insert(new Mark(3, 3));
		academPerfomanceService.createTable();

		// academPerfomanceService.insert(new AcademPerfomance(1, 1, 1,
		// LocalDate.of(2017, 7, 30), 1));
		// academPerfomanceService.insert(new AcademPerfomance(2, 2, 2,
		// LocalDate.of(2017, 7, 31), 2));
		// academPerfomanceService.insert(new AcademPerfomance(3, 3, 3,
		// LocalDate.of(2017, 8, 1), 3));
	}

	@Test
	public final void ok() {

	}

	@Test
	public void testInsert() {
		final AcademPerfomance academPerfomance1
				= new AcademPerfomance(1, new Student(1, "Dave", "Joro"),
									   new Subject(1, "Mathematics"), LocalDate.of(2017, 07, 30),
									   new Mark(1, 1));
		final AcademPerfomance academPerfomance2
				= new AcademPerfomance(1, new Student(2, "Mike", "Franch"),
									   new Subject(2, "Chemistry"), LocalDate.of(2017, 07, 30),
									   new Mark(2, 2));
		final List<AcademPerfomance> expected = new ArrayList<>();
		List<AcademPerfomance> actual = null;
		expected.add(academPerfomance1);
		academPerfomanceService.insert(academPerfomance1);
		actual = academPerfomanceService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.add(academPerfomance2);
		academPerfomanceService.insert(academPerfomance2);
		actual = academPerfomanceService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}
	//
	// @Test
	// public void testSelectAll() {
	// final AcademPerfomance academPerfomance1 = new AcademPerfomance(1, 1, 1,
	// LocalDate.of(2017, 7, 30), 1);
	// final AcademPerfomance academPerfomance2 = new AcademPerfomance(2, 2, 2,
	// LocalDate.of(2017, 7, 31), 2);
	// final AcademPerfomance academPerfomance3 = new AcademPerfomance(3, 3, 3,
	// LocalDate.of(2017, 8, 1), 3);
	// final List<AcademPerfomance> expected = new ArrayList<>();
	// expected.add(academPerfomance1);
	// expected.add(academPerfomance2);
	// expected.add(academPerfomance3);
	// academPerfomanceService.insert(academPerfomance1);
	// academPerfomanceService.insert(academPerfomance2);
	// academPerfomanceService.insert(academPerfomance3);
	// final List<AcademPerfomance> actual =
	// academPerfomanceService.selectAll();
	// assertEquals(expected.toString(), actual.toString());
	// }
	//
	// @Test
	// public void testDelete() {
	// final AcademPerfomance academPerfomance1 = new AcademPerfomance(1, 1, 1,
	// LocalDate.of(2017, 7, 30), 1);
	// final AcademPerfomance academPerfomance2 = new AcademPerfomance(2, 2, 2,
	// LocalDate.of(2017, 7, 31), 2);
	// final AcademPerfomance academPerfomance3 = new AcademPerfomance(3, 3, 3,
	// LocalDate.of(2017, 8, 1), 3);
	// final List<AcademPerfomance> expected = new ArrayList<>();
	// List<AcademPerfomance> actual = null;
	// expected.add(academPerfomance1);
	// expected.add(academPerfomance2);
	// expected.add(academPerfomance3);
	// academPerfomanceService.insert(academPerfomance1);
	// academPerfomanceService.insert(academPerfomance2);
	// academPerfomanceService.insert(academPerfomance3);
	// actual = academPerfomanceService.selectAll();
	// assertEquals(expected.toString(), actual.toString());
	// expected.remove(0);
	// academPerfomanceService.delete(1);
	// actual = academPerfomanceService.selectAll();
	// assertEquals(expected.toString(), actual.toString());
	// expected.remove(0);
	// academPerfomanceService.delete(2);
	// actual = academPerfomanceService.selectAll();
	// assertEquals(expected.toString(), actual.toString());
	// }
	//
	// @Test
	// public final void testUpdate() {
	// final AcademPerfomance academPerfomance1 = new AcademPerfomance(1, 1, 1,
	// LocalDate.of(2017, 7, 30), 1);
	// final AcademPerfomance academPerfomance2 = new AcademPerfomance(2, 2, 2,
	// LocalDate.of(2017, 7, 31), 2);
	// final List<AcademPerfomance> expected = new ArrayList<>();
	// List<AcademPerfomance> actual = null;
	// expected.add(academPerfomance1);
	// expected.add(academPerfomance2);
	// academPerfomanceService.insert(academPerfomance1);
	// academPerfomanceService.insert(academPerfomance2);
	// actual = academPerfomanceService.selectAll();
	// assertEquals(expected.toString(), actual.toString());
	// final AcademPerfomance academPerfomanceToUpdate = new AcademPerfomance(1,
	// 3,
	// 3,
	// LocalDate.of(2013, 4, 2), 3);
	// expected.set(0, academPerfomanceToUpdate);
	// academPerfomanceService.update(academPerfomanceToUpdate);
	// actual = academPerfomanceService.selectAll();
	// assertEquals(expected.toString(), actual.toString());
	// }

	@After
	public final void finish() {
//		academPerfomanceService.dropTable();
//		studentService.dropTable();
//		subjectService.dropTable();
//		markService.dropTable();
	}
}
