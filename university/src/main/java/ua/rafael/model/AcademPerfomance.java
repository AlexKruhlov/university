package ua.rafael.model;

import java.util.List;

public class AcademPerfomance {
	private List<Mark> marks;

	public AcademPerfomance() {
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

	public void addMark(Mark mark) {
		marks.add(mark);
	}

	public void removeMark(Mark mark) {
		marks.remove(mark);
	}
}
