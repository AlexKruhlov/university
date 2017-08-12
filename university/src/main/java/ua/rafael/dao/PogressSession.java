package ua.rafael.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.model.Progress;
import ua.rafael.model.Mark;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;

public class PogressSession {
	private SqlSessionFactory sqlSessionFactory = null;

	public PogressSession(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void createTable() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("AcademPerfomance.createTable");
		} finally {
			session.commit();
			session.close();
		}
	}

	public void insert(final Progress progress) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("AcademPerfomance.insert", progress);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void delete(final long id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("AcademPerfomance.delete", id);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void update(final Progress progress) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("AcademPerfomance.update", progress);
		} finally {
			session.commit();
			session.close();
		}
	}

	public List<Progress> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Progress> resultList = null;
		try {
			resultList = session.selectList("AcademPerfomance.selectAll");
		} finally {
			session.close();
		}
		return resultList;
	}

	public Progress selectById(final long id) {
		Progress result = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.selectOne("AcademPerfomance.selectById", id);
		} finally {
			session.close();
		}
		return result;
	}

	public List<Progress> selectByStudentAndSubject(final Student student,
			final Subject subject) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Progress> resultList = null;
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("inStudent", student);
		parameters.put("inSubject", subject);
		try {
			resultList = session.selectList("AcademPerfomance.selectByStudentAndSubject",
					parameters);
		} finally {
			session.close();
		}
		return resultList;
	}

	public List<Progress> selectByStudentAndDate(final Student student,
			final LocalDate date) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Progress> resultList = null;
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("inStudent", student);
		parameters.put("inDate", date);
		try {
			resultList = session.selectList("AcademPerfomance.selectByStudentAndDate",
					parameters);
		} finally {
			session.close();
		}
		return resultList;
	}

	public Progress selectByStudentAndSubjectAndDate(final Student student,
			final Subject subject, final LocalDate date) {
		Progress resultAcademPerfomance = null;
		SqlSession session = sqlSessionFactory.openSession();
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("inStudent", student);
		parameters.put("inDate", date);
		parameters.put("inSubject", subject);
		try {
			resultAcademPerfomance = session.selectOne(
					"AcademPerfomance.selectByStudentAndSubjectAndDate", parameters);
		} finally {
			session.close();
		}
		return resultAcademPerfomance;
	}

	public double countAverageMarkByStudentAndSubject(final Student student,
			final Subject subject) {
		SqlSession session = sqlSessionFactory.openSession();
		double result = 0.0;
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("inStudent", student);
		parameters.put("inSubject", subject);
		try {
			result = session.selectOne(
					"AcademPerfomance.countAverageMarkByStudentAndSubject",
					parameters);
		} finally {
			session.close();
		}
		return result;
	}

	public void dropTable() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("AcademPerfomance.dropTable");
		} finally {
			session.commit();
			session.close();
		}
	}

}
