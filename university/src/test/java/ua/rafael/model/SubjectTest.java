package ua.rafael.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class SubjectTest {

	@Test
	public void testEqualsWithTheSameReference() {
		final Subject subject1 = new Subject("Mathematics");
		final Subject subject2 = subject1;
		assertTrue("Subjects must be equal", subject1.equals(subject2));
	}

	@Test
	public void testEqualsWithTheEqualSubjects() {
		assertTrue("Subjects must be equal",
				new Subject("Mathematics").equals(new Subject("Mathematics")));
	}

	@Test
	public void testEqualsWithDifferentSubjects() {
		assertFalse("Subjects must not be equal",
				new Subject("Mathematics").equals(new Subject("History")));
	}

	@Test
	public void testEqualsWithNull() {
		assertFalse("Subjects must not be equal",
				new Subject("Mathematics").equals(null));
	}

	@Test
	public void testCompareToFirstSubjectGreaterThanSecond() {
		assertTrue("Result must be > 0",
				new Subject("Physics").compareTo(new Subject("Mathematics")) > 0);
	}

	@Test
	public void testCompareToFirstSubjectLesserThanSecond() {
		assertTrue("Result must be < 0",
				new Subject("Biology").compareTo(new Subject("Chemistry")) < 0);
	}

	@Test
	public void testCompareToSubjectsAreEquals() {
		assertTrue("Result must be == 0",
				new Subject("Biology").compareTo(new Subject("Biology")) == 0);
	}
}
