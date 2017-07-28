package ua.rafael.model;

public class Subject {
	private String name;

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
		return super.hashCode();
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
		return (subject.equals(subject.getName()));
	}
}
