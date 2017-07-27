package ua.rafael.model;

import java.time.LocalDate;

public class Mark {

	private LocalDate date;

	private Subject subject;

	private int value;

	public Mark() {
	}

	public Mark(LocalDate date, Subject subject, int mark) {
		this.date = date;
		this.subject = subject;
		this.value = mark;
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

	public int getValue() {
		return value;
	}

	public void setValue(int mark) {
		this.value = mark;
	}

	@Override
	public String toString() {
		return "date: " + date + " - subject: " + subject.getName() + " - mark: " + value;
	}

}
