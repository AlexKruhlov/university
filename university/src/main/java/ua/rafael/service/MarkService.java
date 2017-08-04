package ua.rafael.service;

import java.util.List;

import ua.rafael.dao.MarkSession;
import ua.rafael.model.Mark;
import ua.rafael.model.Student;
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

	public void delete(final long id) {
		markSession.delete(id);
	}

	public void update(final Mark mark) {
		new MarkValidator().validate(mark);
		markSession.update(mark);
	}

	public List<Mark> findAll() {
		return markSession.selectAll();
	}

	public Mark findById(final long id) {
		return markSession.selectById(id);
	}

	public void dropTable() {
		markSession.dropTable();
	}
}
