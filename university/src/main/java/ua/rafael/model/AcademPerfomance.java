package ua.rafael.model;

import java.time.LocalDate;

public class AcademPerfomance {
	private int id;
	private Student student;
	private Subject subject;
	private LocalDate date;
	private Mark mark;

	public AcademPerfomance() {
	}

	public AcademPerfomance(int id, Student student, Subject subject, LocalDate date, Mark mark) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.date = date;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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

	@Override
	public String toString() {
		return id + "-" + student + "-" + subject + "-" + date + "-" + mark;
	}
}
