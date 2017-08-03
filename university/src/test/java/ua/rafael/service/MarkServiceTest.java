package ua.rafael.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.dao.MarkSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Mark;
import ua.rafael.service.MarkService;

public class MarkServiceTest {

	private MarkService markService;

	@Before
	public final void startUp() {
		MarkSession session = new MarkSession(
				MyBatisConnectionFactory.getSqlSessionFactory());
		markService = new MarkService(session);
		markService.createTable();
	}

	@Test
	public void testInsert() {
		final Mark mark1 = new Mark(1);
		final Mark mark2 = new Mark(2);
		final List<Mark> expected = new ArrayList<>();
		List<Mark> actual = null;
		expected.add(mark1);
		markService.insert(mark1);
		actual = markService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.add(mark2);
		markService.insert(mark2);
		actual = markService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void testSelectAll() {
		final Mark mark1 = new Mark(1);
		final Mark mark2 = new Mark(1);
		final Mark mark3 = new Mark(1);
		final List<Mark> expected = new ArrayList<>();
		expected.add(mark1);
		expected.add(mark2);
		expected.add(mark3);
		markService.insert(mark1);
		markService.insert(mark2);
		markService.insert(mark3);
		final List<Mark> actual = markService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void testDelete() {
		final Mark mark1 = new Mark(1);
		final Mark mark2 = new Mark(1);
		final Mark mark3 = new Mark(1);
		final List<Mark> expected = new ArrayList<>();
		List<Mark> actual = null;
		expected.add(mark1);
		expected.add(mark2);
		expected.add(mark3);
		markService.insert(mark1);
		markService.insert(mark2);
		markService.insert(mark3);
		actual = markService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.remove(0);
		markService.delete(1);
		actual = markService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.remove(0);
		markService.delete(2);
		actual = markService.selectAll();
		assertEquals(expected.toString(), actual.toString());
	}

//	@Test
//	public final void testUpdate() {
//		final Mark mark1 = new Mark(1);
//		final Mark mark2 = new Mark(2);
//		final List<Mark> expected = new ArrayList<>();
//		List<Mark> actual = null;
//		expected.add(mark1);
//		expected.add(mark2);
//		markService.insert(mark1);
//		markService.insert(mark2);
//		actual = markService.selectAll();
//		assertEquals(expected.toString(), actual.toString());
//		final Mark markToUpdate = new Mark(3);
//		expected.set(0, markToUpdate);
//		markService.update(markToUpdate);
//		actual = markService.selectAll();
//		assertEquals(expected.toString(), actual.toString());
//	}

	@After
	public final void finish() {
		markService.dropTable();
	}

}
