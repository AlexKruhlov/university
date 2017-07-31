package validator;

import java.util.LinkedHashSet;
import java.util.List;

import ua.rafael.model.Mark;
import ua.rafael.model.Student;

public class StudentValidator implements Validator<Student> {

	@Override
	public void validate(final Student student) {
		//checkListForTheSameMark(student);
	}

	private void checkListForTheSameMark(final List<Mark> marks) {
		if (new LinkedHashSet<>(marks).size() != marks.size()) {
			throw new RuntimeException("[ERROR]: The same mark on the same date and subject "
					+ "was found");
		}
	}
}
