package ua.rafael.model;

import java.time.LocalDate;

public class Mark implements Comparable<Mark> {
	private int id;
	private LocalDate date;
	private Subject subject;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	public int hashCode() {
		return date.hashCode() + subject.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		final Mark mark = (Mark) obj;
		return (date.equals(mark.date) && subject.equals(mark.subject));
	}

	@Override
	public String toString() {
		return "date: " + date + " - subject: " + subject.getName() + " - mark: " + value + "\n";
	}

	@Override
	public int compareTo(Mark mark) {
		if (date.equals(mark.date)) {
			return subject.compareTo(mark.subject);
		}
		return date.compareTo(mark.date);
	}
}
