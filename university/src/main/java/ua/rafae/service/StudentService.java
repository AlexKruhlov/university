package ua.rafae.service;

import static java.util.Collections.sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ua.rafael.model.Mark;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;

public class StudentService {
	private Student student;

	public StudentService() {
	}

	public StudentService(final Student academPerfomance) {
		this.student = academPerfomance;
	}

	public double solveAvarageMarkBySubject(final Subject subject) {
		List<Mark> marks = student.getMarks();
		if (marks.size() == 0) {
			return 0.0;
		}
		int markValueCount = 0;
		long sumOfMarkValue = 0;
		for (Mark mark : marks) {
			if (mark.getSubject().equals(subject)) {
				sumOfMarkValue += mark.getValue();
				markValueCount++;
			}
		}
		return (markValueCount > 0) ? sumOfMarkValue / markValueCount : markValueCount;
	}

	public void sortMarksByDate() {
		List<Mark> marks = student.getMarks();
		sort(marks);
	}

	public List<Mark> findMarksBySubject(final Subject subject) {
		return student.getMarks().stream()
				.filter(mark -> subject.equals(mark.getSubject()))
				.sorted()
		        .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public List<Mark> findMarksByDate(final LocalDate date) {
		return student.getMarks().stream()
				.filter(mark -> date.equals(mark.getDate()))
				.sorted()
		        .collect(Collectors.toCollection(ArrayList::new));
	}
}
