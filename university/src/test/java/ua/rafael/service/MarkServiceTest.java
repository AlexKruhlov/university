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
	private List<Mark> expected;
	private List<Mark> actual;
	private Mark markWithNullId1;
	private Mark markWithNotNullId1;
	private Mark markWithNullId2;
	private Mark markWithNotNullId2;

	@Before
	public final void startUp() {
		MarkSession session = new MarkSession(
				MyBatisConnectionFactory.getSqlSessionFactory());
		markService = new MarkService(session);
		markService.createTable();
		expected = new ArrayList<>();
		markWithNotNullId1 = new Mark(1);
		markWithNotNullId1.setId(1);
		markWithNullId1 = new Mark(1);
		markWithNotNullId2 = new Mark(2);
		markWithNotNullId2.setId(2);
		markWithNullId2 = new Mark(2);
	}

	@Test
	public void testInsert() {
		expected.add(markWithNotNullId1);
		markService.insert(markWithNullId1);
		actual = markService.selectAll();
		assertEquals("Lists of marks should be equal",expected, actual);
	}

	@Test
	public void testSelectAll() {
		expected.add(markWithNotNullId1);
		expected.add(markWithNotNullId2);
		markService.insert(markWithNullId1);
		markService.insert(markWithNullId2);
		actual = markService.selectAll();
		assertEquals("Lists of marks should be equal",expected, actual);
	}

	@Test
	public void testDelete() {
		expected.add(markWithNotNullId1);
		expected.add(markWithNotNullId2);
		markService.insert(markWithNullId1);
		markService.insert(markWithNullId2);
		actual = markService.selectAll();
		assertEquals(expected.toString(), actual.toString());
		expected.remove(0);
		markService.delete(1);
		actual = markService.selectAll();
		assertEquals("Lists of marks should be equal",expected, actual);
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
