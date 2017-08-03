package ua.rafael.service;

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

public class SubjectServiceTest {
	private SubjectService subjectService;

	@Before
	public final void startUp() {
		SubjectSession session = new SubjectSession(
				MyBatisConnectionFactory.getSqlSessionFactory());
		subjectService = new SubjectService(session);
		subjectService.createTable();
	}

	@Test
	public void testInsert() {
		final Subject subject1 = new Subject(1, "Mathematics");
		final Subject subject2 = new Subject(2, "Biology");
		final List<Subject> expected = new ArrayList<>();
		List<Subject> actual = null;
		expected.add(subject1);
		subjectService.insert(subject1);
		actual = subjectService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.add(subject2);
		subjectService.insert(subject2);
		actual = subjectService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void testSelectAll() {
		final Subject subject1 = new Subject(1, "Mathematics");
		final Subject subject2 = new Subject(2, "Biology");
		final Subject subject3 = new Subject(3, "Chemistry");
		final List<Subject> expected = new ArrayList<>();
		expected.add(subject1);
		expected.add(subject2);
		expected.add(subject3);
		subjectService.insert(subject1);
		subjectService.insert(subject2);
		subjectService.insert(subject3);
		final List<Subject> actual = subjectService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void testDelete() {
		final Subject subject1 = new Subject(1, "Mathematics");
		final Subject subject2 = new Subject(2, "Biology");
		final Subject subject3 = new Subject(3, "Chemistry");
		final List<Subject> expected = new ArrayList<>();
		List<Subject> actual = null;
		expected.add(subject1);
		expected.add(subject2);
		expected.add(subject3);
		subjectService.insert(subject1);
		subjectService.insert(subject2);
		subjectService.insert(subject3);
		actual = subjectService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.remove(0);
		subjectService.delete(1);
		actual = subjectService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.remove(0);
		subjectService.delete(2);
		actual = subjectService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public final void testUpdate() {
		final Subject subject1 = new Subject(1, "Mathematics");
		final Subject subject2 = new Subject(2, "Biology");
		final List<Subject> expected = new ArrayList<>();
		List<Subject> actual = null;
		expected.add(subject1);
		expected.add(subject2);
		subjectService.insert(subject1);
		subjectService.insert(subject2);
		actual = subjectService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		Subject subjectToUpdate = new Subject(1, "Chemistry");
		expected.set(0, subjectToUpdate);
		subjectService.update(subjectToUpdate);
		actual = subjectService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

	@After
	public final void finish() {
		subjectService.dropTable();
	}
}
