package ua.rafael.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.rafael.dao.AcademPerfomanceSession;
import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;
import validator.AcademPerfomanceValidator;

public class AcademPerfomanceService {
	private AcademPerfomanceSession academPerfomanceSession;

	public AcademPerfomanceService(AcademPerfomanceSession academPerfomanceSession) {
		this.academPerfomanceSession = academPerfomanceSession;
	}

	public void createTable() {
		academPerfomanceSession.createTable();
	}

	public void insert(final AcademPerfomance academPerfomance) {
		new AcademPerfomanceValidator().validate(academPerfomance);
		academPerfomanceSession.insert(academPerfomance);
	}

	public void delete(final int id) {
		academPerfomanceSession.delete(id);
	}

	public void update(final AcademPerfomance academPerfomance) {
		new AcademPerfomanceValidator().validate(academPerfomance);
		academPerfomanceSession.update(academPerfomance);
	}

	public List<AcademPerfomance> selectAll() {
		return academPerfomanceSession.selectAll();
	}

	public List<AcademPerfomance> selectByStudentAndSubject(final Student student,
			final Subject subject) {
		return academPerfomanceSession.selectByStudentAndSubject(student, subject);
	}
	
	public List<AcademPerfomance> selectByStudentAndDate(final Student student,
			final LocalDate date) {
		return academPerfomanceSession.selectByStudentAndDate(student, date);
	}
	public void dropTable() {
		academPerfomanceSession.dropTable();
	}
}
