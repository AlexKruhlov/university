package ua.rafael.model;

import java.util.ArrayList;
import java.util.List;

public class AcademPerfomance {
	private List<Mark> marks;

	public AcademPerfomance() {
		marks = new ArrayList<Mark>();
	}

	public AcademPerfomance(List<Mark> marks) {
		this.marks = marks;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return marks.toString();
	}
}
