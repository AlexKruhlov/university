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
	private List<Subject> expected;
	private List<Subject> actual;
	private Subject subjectWithNullId1;
	private Subject subjectWithNotNullId1;
	private Subject subjectWithNullId2;
	private Subject subjectWithNotNullId2;

	@Before
	public final void startUp() {
		SubjectSession session
				= new SubjectSession(MyBatisConnectionFactory.getSqlSessionFactory());
		subjectService = new SubjectService(session);
		subjectService.createTable();
		expected = new ArrayList<>();
		subjectWithNotNullId1 = new Subject("Mathematics");
		subjectWithNotNullId1.setId(1);
		subjectWithNullId1 = new Subject("Mathematics");
		subjectWithNotNullId2 = new Subject("Biology");
		subjectWithNotNullId2.setId(2);
		subjectWithNullId2 = new Subject("Biology");
	}

	@Test
	public void testInsert() {
		expected.add(subjectWithNotNullId1);
		subjectService.insert(subjectWithNullId1);
		actual = subjectService.findAll();
		assertEquals("Lists of subjects should be equal", expected, actual);
	}

	@Test
	public void testSelectAll() {
		expected.add(subjectWithNotNullId1);
		expected.add(subjectWithNotNullId2);
		subjectService.insert(subjectWithNullId1);
		subjectService.insert(subjectWithNullId2);
		actual = subjectService.findAll();
		assertEquals("Lists of subjects should be equal", expected, actual);
	}
	
	@Test
	public void testSelectById() {
		final Subject expected = subjectWithNotNullId2;
		subjectService.insert(subjectWithNullId1);
		subjectService.insert(subjectWithNullId2);
		final Subject actual = subjectService.findById(2);
		assertEquals(expected, actual);
	}

	@Test
	public void testDelete() {
		expected.add(subjectWithNotNullId1);
		expected.add(subjectWithNotNullId2);
		subjectService.insert(new Subject("Mathematics"));
		subjectService.insert(new Subject("Biology"));
		actual = subjectService.findAll();
		assertEquals(expected, actual);
		expected.remove(0);
		subjectService.delete(1);
		actual = subjectService.findAll();
		assertEquals("Lists of subjects should be equal", expected, actual);
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
}