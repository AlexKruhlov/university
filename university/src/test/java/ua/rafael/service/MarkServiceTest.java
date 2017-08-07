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
		actual = markService.findAll();
		assertEquals("Lists of marks should be equal", expected, actual);
	}

	@Test
	public void testFindAll() {
		expected.add(markWithNotNullId1);
		expected.add(markWithNotNullId2);
		markService.insert(markWithNullId1);
		markService.insert(markWithNullId2);
		actual = markService.findAll();
		assertEquals("Lists of marks should be equal", expected, actual);
	}

	@Test
	public void testFindById() {
		final Mark expected = markWithNotNullId2;
		markService.insert(markWithNullId1);
		markService.insert(markWithNullId2);
		final Mark actual = markService.findById(2);
		assertEquals(expected, actual);
	}

	@Test
	public void testDelete() {
		expected.add(markWithNotNullId1);
		expected.add(markWithNotNullId2);
		markService.insert(markWithNullId1);
		markService.insert(markWithNullId2);
		actual = markService.findAll();
		assertEquals(expected.toString(), actual.toString());
		expected.remove(0);
		markService.delete(1);
		actual = markService.findAll();
		assertEquals("Lists of marks should be equal", expected, actual);
	}

	@Test
	public final void testUpdate() {
		markWithNotNullId2.setId(1);
		expected.add(markWithNotNullId2);
		markService.insert(markWithNullId1);
		markService.update(1, markWithNullId2);
		actual = markService.findAll();
		assertEquals(expected, actual);
	}

	@After
	public final void finish() {
		markService.dropTable();
	}

}
