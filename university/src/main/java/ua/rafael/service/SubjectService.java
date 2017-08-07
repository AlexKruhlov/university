package ua.rafael.service;

import java.util.List;

import ua.rafael.dao.SubjectSession;
import ua.rafael.model.Subject;
import validator.SubjectValidator;

public class SubjectService {
	SubjectSession subjectSession;

	public SubjectService(SubjectSession subjectSession) {
		this.subjectSession = subjectSession;
	}

	public void createTable() {
		subjectSession.createTable();
	}

	public void insert(final Subject subject) {
		new SubjectValidator().validate(subject);
		subjectSession.insert(subject);
	}

	public void delete(final long id) {
		subjectSession.delete(id);
	}

	public void update(final long id, final Subject subject) {
		final Subject subjectFromDB = findById(id);
		if (subjectFromDB != null) {
			subject.setId(id);
			subjectSession.update(subject);
		}
	}

	public List<Subject> findAll() {
		return subjectSession.selectAll();
	}

	public Subject findById(final long id) {
		return subjectSession.selectById(id);
	}

	public void dropTable() {
		subjectSession.dropTable();
	}
}
