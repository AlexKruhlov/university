package ua.rafael.model;

import java.time.LocalDate;

public class AcademPerfomance {
	private int id;
	private int studentId;
	private int subjectId;
	private LocalDate date;
	private int markId;

	public AcademPerfomance() {
	}

	public AcademPerfomance(int id, int studentId, int subjectId, LocalDate date, int markId) {
		this.id = id;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.date = date;
		this.markId = markId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getMarkId() {
		return markId;
	}

	public void setMarkId(int markId) {
		this.markId = markId;
	}

	@Override
	public String toString() {
		return id + "-" + studentId + "-" + subjectId + "-" + date + "-" + markId;
	}
}
