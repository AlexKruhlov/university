package ua.rafael.service;

import java.time.LocalDate;
import java.util.List;

import ua.rafael.dao.AcademPerfomanceSession;
import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;
import validation.AcademPerfomanceValidator;

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

	public void delete(final long id) {
		academPerfomanceSession.delete(id);
	}

	public void update(final long id, final AcademPerfomance academPerfomance) {
		final AcademPerfomance academPerfomanceFromDB = findById(id);
		if (academPerfomanceFromDB != null) {
			academPerfomance.setId(id);
			academPerfomanceSession.update(academPerfomance);
		}
	}

	public List<AcademPerfomance> findAll() {
		return academPerfomanceSession.selectAll();
	}

	public AcademPerfomance findById(final long id) {
		return academPerfomanceSession.selectById(id);
	}

	public List<AcademPerfomance> findBy(final Student student,
			final Subject subject) {
		return academPerfomanceSession.selectByStudentAndSubject(student, subject);
	}

	public List<AcademPerfomance> findBy(final Student student,
			final LocalDate date) {
		return academPerfomanceSession.selectByStudentAndDate(student, date);
	}

	public AcademPerfomance findBy(final Student student, final Subject subject,
			final LocalDate date) {
		return academPerfomanceSession.selectByStudentAndSubjectAndDate(student, subject, date);
	}

	public double countAverageBy(final Student student,
			final Subject subject) {
		return academPerfomanceSession.countAverageMarkByStudentAndSubject(student, subject);
	}

	public void dropTable() {
		academPerfomanceSession.dropTable();
	}
}
