package validator;

import static org.junit.Assert.fail;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.Test;

import ua.rafael.model.Mark;
import ua.rafael.model.Subject;

public class MarkValidatorTest {

	private Validator<Mark> validator = new MarkValidator();

	@Test
	public void testValidateWithCorrectMark() {
		final Mark mark = new Mark(LocalDate.now(), new Subject("History"), 3);
		try {
			validator.validate(mark);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@Test(expected = DateTimeException.class)
	public void testValidateWithWrongYearRange() {
		final Mark mark = new Mark(LocalDate.now().plusYears(1), new Subject("History"), 3);
		validator.validate(mark);
		LocalDate.now().plusDays(1);
	}
	
	@Test(expected = DateTimeException.class)
	public void testValidateWithWrongMonthRange() {
		final Mark mark = new Mark(LocalDate.now().plusMonths(1), new Subject("History"), 3);
		validator.validate(mark);
	}
	
	@Test(expected = DateTimeException.class)
	public void testValidateWithWrongDayRange() {
		final Mark mark = new Mark(LocalDate.now().plusDays(1), new Subject("History"), 3);
		validator.validate(mark);
	}
	
	@Test(expected = RuntimeException.class)
	public void testValidateWithWrongSubject(){
		final Mark mark = new Mark(LocalDate.now().plusDays(1), new Subject("History1"), 3);
		validator.validate(mark);	
	}
}
