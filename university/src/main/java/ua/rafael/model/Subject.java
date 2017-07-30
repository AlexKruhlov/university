package ua.rafael.model;

public class Subject implements Comparable<Subject> {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject() {
	}

	public Subject(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		final Subject subject = (Subject) obj;
		return (name.equals(subject.name));
	}

	@Override
	public int compareTo(Subject subject) {
		return name.compareTo(subject.name);
	}

	@Override
	public String toString() {
		return id + "-" + name;
	}
}
