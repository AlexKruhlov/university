package ua.rafae.service;

import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Mark;
import ua.rafael.model.Subject;

public class AcademPerfomanceService {
	private AcademPerfomance academPerfomance;

	public AcademPerfomanceService() {
	}

	public AcademPerfomanceService(AcademPerfomance academPerfomance) {
		this.academPerfomance = academPerfomance;
	}

	public double solveAvarageMarkBySubject(final Subject subject) {
		List<Mark> marks = academPerfomance.getMarks();
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
		List<Mark> marks = academPerfomance.getMarks();
		sort(marks);
	}

	public List<Mark> findMarksBySubject(final Subject subject) {
		return academPerfomance.getMarks().stream()
				.filter(mark -> subject.equals(mark.getSubject()))
				.sorted()
		        .collect(Collectors.toCollection(ArrayList::new));
	}
	
}
