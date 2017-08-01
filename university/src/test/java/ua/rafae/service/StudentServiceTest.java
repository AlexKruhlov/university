package ua.rafae.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.dao.StudentSession;
import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;

public class StudentServiceTest {

	private StudentService studentService;

	@Before
	public final void startUp() {
		StudentSession session = new StudentSession(
				MyBatisConnectionFactory.getSqlSessionFactory());
		studentService = new StudentService(session);
		studentService.createTable();
	}

	@Test
	public void testInsert() {
		final Student student1 = new Student(1, "Dave","Joro");
		final Student student2 = new Student(2, "Mike","Franch");
		final List<Student> expected = new ArrayList<>();
		List<Student> actual = null;
		expected.add(student1);
		studentService.insert(student1);
		actual = studentService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.add(student2);
		studentService.insert(student2);
		actual = studentService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void testSelectAll() {
		final Student student1 = new Student(1, "Dave","Joro");
		final Student student2 = new Student(2, "Mike","Franch");
		final Student student3 = new Student(3, "Sindey","Grant");
		final List<Student> expected = new ArrayList<>();
		expected.add(student1);
		expected.add(student2);
		expected.add(student3);
		studentService.insert(student1);
		studentService.insert(student2);
		studentService.insert(student3);
		final List<Student> actual = studentService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void testDelete() {
		final Student student1 = new Student(1, "Dave","Joro");
		final Student student2 = new Student(2, "Mike","Franch");
		final Student student3 = new Student(3, "Sindey","Grant");
		final List<Student> expected = new ArrayList<>();
		List<Student> actual = null;
		expected.add(student1);
		expected.add(student2);
		expected.add(student3);
		studentService.insert(student1);
		studentService.insert(student2);
		studentService.insert(student3);
		actual = studentService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.remove(0);
		studentService.delete(1);
		actual = studentService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.remove(0);
		studentService.delete(2);
		actual = studentService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public final void testUpdate() {
		final Student student1 = new Student(1, "Dave","Joro");
		final Student student2 = new Student(2, "Mike","Franch");
		final List<Student> expected = new ArrayList<>();
		List<Student> actual = null;
		expected.add(student1);
		expected.add(student2);
		studentService.insert(student1);
		studentService.insert(student2);
		actual = studentService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		final Student studentToUpdate = new Student(1, "Sindey","Grant");
		expected.set(0, studentToUpdate);
		studentService.update(studentToUpdate);
		actual = studentService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

	@After
	public final void finish() {
		studentService.dropTable();
	}

}
