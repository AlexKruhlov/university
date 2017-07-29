package ua.rafae.service;

import java.util.List;

import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Mark;

public class AcademPerfomanceService {
	private AcademPerfomance academPerfomance;

	public AcademPerfomanceService() {
	}

	public AcademPerfomanceService(AcademPerfomance academPerfomance) {
		this.academPerfomance = academPerfomance;
	}

	public double solveAvarageMarkBySubject() {
		List<Mark> marks = academPerfomance.getMarks();
		if (marks.size() == 0) {
			return 0.0;
		}
		long sumOfMarks = marks
			.parallelStream()
			.filter(mark -> mark.getValue() == 4)
			.mapToInt(mark -> mark.getValue())
			.sum();
		return sumOfMarks / 4;
	}
}
