package ua.rafael.model;

import java.util.List;

public class Student {
	private int id;
	private String name;
	private List<Mark> marks;
	
	public Student() {
	}

	public Student(int id, String name, List<Mark> marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
}
