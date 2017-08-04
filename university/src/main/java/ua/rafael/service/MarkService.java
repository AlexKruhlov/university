package ua.rafael.service;

import java.util.List;

import ua.rafael.dao.MarkSession;
import ua.rafael.model.Mark;
import validator.MarkValidator;

public class MarkService {
	MarkSession markSession;

	public MarkService(MarkSession markSession) {
		this.markSession = markSession;
	}

	public void createTable() {
		markSession.createTable();
	}

	public void insert(final Mark mark) {
		new MarkValidator().validate(mark);
		markSession.insert(mark);
	}

	public void delete(final int id) {
		markSession.delete(id);
	}

	public void update(final Mark mark) {
		new MarkValidator().validate(mark);
		markSession.update(mark);
	}

	public List<Mark> selectAll() {
		return markSession.selectAll();
	}

	public void dropTable() {
		markSession.dropTable();
	}
}