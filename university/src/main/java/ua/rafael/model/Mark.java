package ua.rafael.model;

import java.time.LocalDate;

public class Mark {
	private LocalDate date;
	private Subject subject;
	private int mark;

	public Mark() {
	}

	public Mark(LocalDate date, Subject subject, int mark) {
		super();
		this.date = date;
		this.subject = subject;
		this.mark = mark;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
}
