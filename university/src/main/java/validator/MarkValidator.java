package validator;

import java.time.DateTimeException;
import java.time.LocalDate;

import ua.rafael.model.Mark;

public class MarkValidator implements Validator<Mark> {

	@Override
	public void validate(final Mark mark) {
		checkDateRange(mark.getDate());
		checkMarkRange(mark.getValue());
	}

	public void checkDateRange(LocalDate date) {
		if (!(date.isEqual(LocalDate.now()) || date.isBefore(LocalDate.now()))) {
			throw new DateTimeException("[ERROR]: Date must not be in future");
		}
	}

	private void checkMarkRange(final int markValue) {
		if (markValue <= 0) {
			throw new RuntimeException("Mark must not be negative digit");
		}
	}
}
