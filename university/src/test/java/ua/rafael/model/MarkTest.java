package ua.rafael.model;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class MarkTest {

	@Test
	public void testEqualsWithTheSameReference() {
		final Mark mark1 = new Mark(LocalDate.now(), new Subject("Mathematics"), 2);
		final Mark mark2 = mark1;
		assertTrue("Marks must be equal", mark1.equals(mark2));
	}

	@Test
	public void testEqualsWithTheEqualMarks() {
		final Mark mark1 = new Mark(LocalDate.now(), new Subject("Mathematics"), 2);
		final Mark mark2 = new Mark(LocalDate.now(), new Subject("Mathematics"), 2);
		assertTrue("Marks must be equal", mark1.equals(mark2));
	}

	@Test
	public void testEqualsWithDifferentSubjects() {
		final Mark mark1 = new Mark(LocalDate.now(), new Subject("Mathematics"), 2);
		final Mark mark2 = new Mark(LocalDate.now(), new Subject("History"), 2);
		assertFalse("Marks must not be equal", mark1.equals(mark2));
	}

	@Test
	public void testEqualsWithDifferentDates() {
		final Mark mark1 = new Mark(LocalDate.now(), new Subject("Mathematics"), 2);
		final Mark mark2 = new Mark(LocalDate.now().plusDays(1), new Subject("Mathematics"), 2);
		assertFalse("Marks must not be equal", mark1.equals(mark2));
	}

	@Test
	public void testEqualsWithNull() {
		final Mark mark = new Mark(LocalDate.now(), new Subject("Mathematics"), 2);
		assertFalse("Subjects must not be equal", mark.equals(null));
	}

	@Test
	public void testCompareToFirstMarkGreaterThanSecondWithTheSameDate() {
		final Mark mark1 = new Mark(LocalDate.now(), new Subject("Mathematics"), 2);
		final Mark mark2 = new Mark(LocalDate.now(), new Subject("Biology"), 2);
		assertTrue("Result must be > 0", mark1.compareTo(mark2) > 0);
	}

	@Test
	public void testCompareToFirstMarkLesserThanSecondWithTheSameDate() {
		final Mark mark1 = new Mark(LocalDate.now(), new Subject("Chemistry"), 2);
		final Mark mark2 = new Mark(LocalDate.now(), new Subject("Physics"), 2);
		assertTrue("Result must be < 0", mark1.compareTo(mark2) < 0);
	}

	@Test
	public void testCompareToFirstMarkGreaterThanSecondWithTheSameSubject() {
		final Mark mark1 = new Mark(LocalDate.now().plusDays(1), new Subject("Chemistry"), 2);
		final Mark mark2 = new Mark(LocalDate.now(), new Subject("Chemistry"), 2);
		assertTrue("Result must be > 0", mark1.compareTo(mark2) > 0);
	}

	@Test
	public void testCompareToFirstMarkLesserThanSecondWithTheSameSubject() {
		final Mark mark1 = new Mark(LocalDate.now(), new Subject("Chemistry"), 2);
		final Mark mark2 = new Mark(LocalDate.now().plusDays(1), new Subject("Chemistry"), 2);
		assertTrue("Result must be < 0", mark1.compareTo(mark2) < 0);
	}

	@Test
	public void testCompareToMarkAreEqual() {
		final Mark mark1 = new Mark(LocalDate.now(), new Subject("Chemistry"), 2);
		final Mark mark2 = new Mark(LocalDate.now(), new Subject("Chemistry"), 2);
		assertTrue("Result must be == 0", mark1.compareTo(mark2) == 0);
	}
}
