package ua.rafael.model;

import java.time.LocalDate;

public class AcademPerfomance {
	private int id;
	private int studentId;
	private int subjectId;
	private LocalDate date;
	private Mark mark;
	
	public AcademPerfomance() {
	}

	public AcademPerfomance(int id, int studentId, int subjectId, LocalDate date, Mark mark) {
		this.id = id;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.date = date;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudent_id() {
		return studentId;
	}

	public void setStudent_id(int studentId) {
		this.studentId = studentId;
	}

	public int getSubject_id() {
		return subjectId;
	}

	public void setSubject_id(int subjectId) {
		this.subjectId = subjectId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}
}
