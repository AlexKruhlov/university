package ua.rafael.model;

public class Mark implements Comparable<Mark> {
	private int id;
	private int value;

	public Mark() {
	}

	public Mark(int id, int value) {
		super();
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int compareTo(Mark mark) {
		return value - mark.value;
	}
}
