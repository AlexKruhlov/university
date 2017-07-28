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
}
