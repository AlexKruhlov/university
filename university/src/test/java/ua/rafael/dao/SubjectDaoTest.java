package ua.rafael.dao;

import static org.junit.Assert.*;
import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.model.Subject;

public class SubjectDaoTest {
	private SubjectSession subjectDao;

//	@Before
//	public final void startUp() {
//		subjectDao = new SubjectSession(getSqlSessionFactory());
//		subjectDao.createTable();
//	}
//
//	@Test
//	public void testInsert() {
//		final Subject subject1 = new Subject(1, "Mathematics");
//		final Subject subject2 = new Subject(2, "Biology");
//		final List<Subject> expected = new ArrayList<>();
//		List<Subject> actual = null;
//		expected.add(subject1);
//		subjectDao.insert(subject1);
//		actual = subjectDao.selectAll();
//		assertEquals(expected.toString(), actual.toString());
//		expected.add(subject2);
//		subjectDao.insert(subject2);
//		actual = subjectDao.selectAll();
//		assertEquals(expected.toString(), actual.toString());
//	}
//
//	@Test
//	public void testSelectAll() {
//		final Subject subject1 = new Subject(1, "Mathematics");
//		final Subject subject2 = new Subject(2, "Biology");
//		final Subject subject3 = new Subject(3, "Chemistry");
//		final List<Subject> expected = new ArrayList<>();
//		expected.add(subject1);
//		expected.add(subject2);
//		expected.add(subject3);
//		subjectDao.insert(subject1);
//		subjectDao.insert(subject2);
//		subjectDao.insert(subject3);
//		final List<Subject> actual = subjectDao.selectAll();
//		assertEquals(expected.toString(), actual.toString());
//	}
//
//	@Test
//	public void testDelete() {
//		final Subject subject1 = new Subject(1, "Mathematics");
//		final Subject subject2 = new Subject(2, "Biology");
//		final Subject subject3 = new Subject(3, "Chemistry");
//		final List<Subject> expected = new ArrayList<>();
//		List<Subject> actual = null;
//		expected.add(subject1);
//		expected.add(subject2);
//		expected.add(subject3);
//		subjectDao.insert(subject1);
//		subjectDao.insert(subject2);
//		subjectDao.insert(subject3);
//		actual = subjectDao.selectAll();
//		assertEquals(expected.toString(), actual.toString());
//		expected.remove(0);
//		subjectDao.delete(1);
//		actual = subjectDao.selectAll();
//		assertEquals(expected.toString(), actual.toString());
//		expected.remove(0);
//		subjectDao.delete(2);
//		actual = subjectDao.selectAll();
//		assertEquals(expected.toString(), actual.toString());
//	}
//
//	@Test
//	public final void update() {
//		final Subject subject1 = new Subject(1, "Mathematics");
//		final Subject subject2 = new Subject(2, "Biology");
//		final List<Subject> expected = new ArrayList<>();
//		List<Subject> actual = null;
//		expected.add(subject1);
//		expected.add(subject2);
//		subjectDao.insert(subject1);
//		subjectDao.insert(subject2);
//		actual = subjectDao.selectAll();
//		assertEquals(expected.toString(), actual.toString());
//		Subject subjectToUpdate = new Subject(1,"Chemistry"); 
//		expected.set(0, subjectToUpdate);
//		subjectDao.update(subjectToUpdate);
//		actual = subjectDao.selectAll();
//		Collections.sort(expected);
//		assertEquals(expected.toString(), actual.toString());
//	}
//
//	@After
//	public final void finish() {
//		subjectDao.dropTable();
//	}
}
