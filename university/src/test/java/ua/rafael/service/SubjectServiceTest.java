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
		final List<Subject> expected = new ArrayList<>();
		List<Subject> actual = null;
		expected.add(createSubject(1, "Mathematics"));
		subjectService.insert(new Subject("Mathematics"));
		actual = subjectService.selectAll();
		assertEquals(expected, actual);
	}

	@Test
	public void testSelectAll() {
		final List<Subject> expected = new ArrayList<>();
		expected.add(createSubject(1, "Mathematics"));
		expected.add(createSubject(2, "Biology"));
		expected.add(createSubject(3, "Chemistry"));
		subjectService.insert(new Subject("Mathematics"));
		subjectService.insert(new Subject("Biology"));
		subjectService.insert(new Subject("Chemistry"));
		final List<Subject> actual = subjectService.selectAll();
		assertEquals(expected, actual);
	}

	@Test
	public void testDelete() {
		final List<Subject> expected = new ArrayList<>();
		List<Subject> actual = null;
		expected.add(createSubject(1, "Mathematics"));
		expected.add(createSubject(2, "Biology"));
		subjectService.insert(new Subject("Mathematics"));
		subjectService.insert(new Subject("Biology"));
		actual = subjectService.selectAll();
		assertEquals(expected, actual);
		expected.remove(0);
		subjectService.delete(1);
		actual = subjectService.selectAll();
		assertEquals(expected, actual);
	}

	// @Test
	// public final void testUpdate() {
	// final Subject subject1 = new Subject("Mathematics");
	// final Subject subject2 = new Subject("Biology");
	// final List<Subject> expected = new ArrayList<>();
	// List<Subject> actual = null;
	// expected.add(subject1);
	// expected.add(subject2);
	// subjectService.insert(subject1);
	// subjectService.insert(subject2);
	// actual = subjectService.selectAll();
	// assertEquals(expected.toString(), actual.toString());
	// Subject subjectToUpdate = new Subject("Chemistry");
	// expected.set(0, subjectToUpdate);
	// subjectService.update(subjectToUpdate);
	// actual = subjectService.selectAll();
	// assertEquals(expected.toString(), actual.toString());
	// }

	@After
	public final void finish() {
		subjectService.dropTable();
	}

	private Subject createSubject(final long id, final String name) {
		final Subject subject = new Subject(name);
		subject.setId(id);
		return subject;
	}
}
