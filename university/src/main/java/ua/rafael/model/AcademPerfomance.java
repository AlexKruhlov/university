package ua.rafael.model;

import java.time.LocalDate;

public class AcademPerfomance {
	private int id;
	private int student_id;
	private int subject_id;
	private LocalDate date;
	private Mark mark;
	
	public AcademPerfomance() {
	}

	public AcademPerfomance(int id, int student_id, int subject_id, LocalDate date, Mark mark) {
		this.id = id;
		this.student_id = student_id;
		this.subject_id = subject_id;
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
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
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
