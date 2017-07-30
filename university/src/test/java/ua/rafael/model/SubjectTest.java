package ua.rafael.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class SubjectTest {

	@Test
	public void testEqualsWithTheSameReference() {
		final Subject subject1 = new Subject(1,"Mathematics");
		final Subject subject2 = subject1;
		assertTrue("Subjects must be equal", subject1.equals(subject2));
	}

	@Test
	public void testEqualsWithTheEqualSubjects() {
		assertTrue("Subjects must be equal",
				new Subject(1,"Mathematics").equals(new Subject(1,"Mathematics")));
	}

	@Test
	public void testEqualsWithDifferentSubjects() {
		assertFalse("Subjects must not be equal",
				new Subject(1,"Mathematics").equals(new Subject(1,"History")));
	}

	@Test
	public void testEqualsWithNull() {
		assertFalse("Subjects must not be equal",
				new Subject(1,"Mathematics").equals(null));
	}

	@Test
	public void testCompareToFirstSubjectGreaterThanSecond() {
		assertTrue("Result must be > 0",
				new Subject(1,"Physics").compareTo(new Subject(1,"Mathematics")) > 0);
	}

	@Test
	public void testCompareToFirstSubjectLesserThanSecond() {
		assertTrue("Result must be < 0",
				new Subject(1,"Biology").compareTo(new Subject(1,"Chemistry")) < 0);
	}

	@Test
	public void testCompareToSubjectsAreEqual() {
		assertTrue("Result must be == 0",
				new Subject(1,"Biology").compareTo(new Subject(1,"Biology")) == 0);
	}
}
