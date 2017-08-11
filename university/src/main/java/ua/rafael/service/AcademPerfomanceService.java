package ua.rafael.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.AcademPerfomanceSession;
import ua.rafael.dao.MarkSession;
import ua.rafael.dao.StudentSession;
import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;
import validation.AcademPerfomanceValidator;

public class AcademPerfomanceService {
	private AcademPerfomanceSession academPerfomanceSession;
	SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	StudentService studentService = new StudentService(new StudentSession(sessionFactory));
	SubjectService subjectService = new SubjectService(new SubjectSession(sessionFactory));
	MarkService markService = new MarkService(new MarkSession(sessionFactory));

	public AcademPerfomanceService(AcademPerfomanceSession academPerfomanceSession) {
		this.academPerfomanceSession = academPerfomanceSession;
	}

	public void createTable() {
		academPerfomanceSession.createTable();
	}

	public void insert(final AcademPerfomance academPerfomance) {
		academPerfomance
				.setStudent(studentService.findByName(academPerfomance.getStudent().getFirstName(),
						academPerfomance.getStudent().getLastName()));
		//TODO subject all
		academPerfomance
				.setSubject(subjectService.findByName(academPerfomance.getSubject().getName()));
		academPerfomance.setMark(markService.findByValue(academPerfomance.getMark().getValue()));
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
