package validator;

import java.util.LinkedHashSet;
import java.util.List;

import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Mark;

public class AcademPerfomanceValidator implements Validator<AcademPerfomance> {

	@Override
	public void validate(AcademPerfomance academPerfomance) {
		checkListForTheSameMark(academPerfomance.getMarks());
	}

	private void checkListForTheSameMark(final List<Mark> marks) {
		if (new LinkedHashSet<>(marks).size() != marks.size()) {
			throw new RuntimeException("[ERROR]: The same mark on the same date and subject "
					+ "was found");
		}
	}
}
