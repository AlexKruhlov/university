package ua.rafael.service;

import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.PogressSession;
import ua.rafael.dao.MarkSession;
import ua.rafael.dao.StudentSession;
import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Progress;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;
import validation.ProgressValidator;

public class ProgressService {
	private PogressSession progressSession;
	SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	StudentService studentService = new StudentService(new StudentSession(sessionFactory));
	SubjectService subjectService = new SubjectService(new SubjectSession(sessionFactory));
	MarkService markService = new MarkService(new MarkSession(sessionFactory));

	public ProgressService(PogressSession progressSession) {
		this.progressSession = progressSession;
	}

	public void createTable() {
		progressSession.createTable();
	}

	public void insert(final Progress progress) {
		try {
			
			new ProgressValidator().validate(progress);
			progressSession.insert(progress);
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}

	}

	public void delete(final long id) {
		progressSession.delete(id);
	}

	public void update(final long id, final Progress progress) {
		final Progress progressFromDB = findById(id);
		if (progressFromDB != null) {
			progress.setId(id);
			progressSession.update(progress);
		}
	}

	public List<Progress> findAll() {
		return progressSession.selectAll();
	}

	public Progress findById(final long id) {
		return progressSession.selectById(id);
	}

	public List<Progress> findBy(final Student student,
			final Subject subject) {
		return progressSession.selectByStudentAndSubject(student, subject);
	}

	public List<Progress> findBy(final Student student,
			final LocalDate date) {
		return progressSession.selectByStudentAndDate(student, date);
	}

	public Progress findBy(final Student student, final Subject subject,
			final LocalDate date) {
		return progressSession.selectByStudentAndSubjectAndDate(student, subject, date);
	}

	public double countAverageBy(final Student student,
			final Subject subject) {
		return progressSession.countAverageMarkByStudentAndSubject(student, subject);
	}

	public void dropTable() {
		progressSession.dropTable();
	}
}
