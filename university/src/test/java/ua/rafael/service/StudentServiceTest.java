package ua.rafael.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.dao.StudentSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Student;
import ua.rafael.service.StudentService;

public class StudentServiceTest {
	private StudentService studentService;
	private List<Student> expected;
	private List<Student> actual;
	private Student studentWithNullId1;
	private Student studentWithNotNullId1;
	private Student studentWithNullId2;
	private Student studentWithNotNullId2;

	@Before
	public final void startUp() {
		StudentSession session
				= new StudentSession(MyBatisConnectionFactory.getSqlSessionFactory());
		studentService = new StudentService(session);
		studentService.createTable();
		expected = new ArrayList<>();
		studentWithNotNullId1 = new Student("Dave", "Joro");
		studentWithNotNullId1.setId(1);
		studentWithNullId1 = new Student("Dave", "Joro");
		studentWithNotNullId2 = new Student("Mike", "Franch");
		studentWithNotNullId2.setId(2);
		studentWithNullId2 = new Student("Mike", "Franch");
	}

	@Test
	public void testInsert() {
		expected.add(studentWithNotNullId1);
		studentService.insert(studentWithNullId1);
		actual = studentService.selectAll();
		assertEquals("Lists of students should be equal", expected, actual);
	}

	@Test
	public void testSelectAll() {
		expected.add(studentWithNotNullId1);
		expected.add(studentWithNotNullId2);
		studentService.insert(studentWithNullId1);
		studentService.insert(studentWithNullId2);
		actual = studentService.selectAll();
		assertEquals("Lists of students should be equal", expected, actual);
	}

	@Test
	public void testDelete() {
		expected.add(studentWithNotNullId1);
		expected.add(studentWithNotNullId2);
		studentService.insert(studentWithNullId1);
		studentService.insert(studentWithNullId2);
		actual = studentService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.remove(0);
		studentService.delete(1);
		actual = studentService.selectAll();
		assertEquals("Lists of students should be equal", expected, actual);
	}

	// @Test
	// public final void testUpdate() {
	// final Student student1 = new Student("Dave", "Joro");
	// final Student student2 = new Student("Mike", "Franch");
	// final List<Student> expected = new ArrayList<>();
	// List<Student> actual = null;
	// expected.add(student1);
	// expected.add(student2);
	// studentService.insert(student1);
	// studentService.insert(student2);
	// actual = studentService.selectAll();
	// assertEquals(expected.toString(), actual.toString());
	// final Student studentToUpdate = new Student("Sindey", "Grant");
	// expected.set(0, studentToUpdate);
	// studentService.update(studentToUpdate);
	// actual = studentService.selectAll();
	// assertEquals(expected.toString(), actual.toString());
	// }

	@After
	public final void finish() {
		studentService.dropTable();
	}
}