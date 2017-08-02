package ua.rafael.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;

public class AcademPerfomanceSession {
	private SqlSessionFactory sqlSessionFactory = null;

	public AcademPerfomanceSession(SqlSessionFactory sqlSessionFactory) {
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

	public void insert(final AcademPerfomance academPerfomance) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("AcademPerfomance.insert", academPerfomance);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void delete(final int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("AcademPerfomance.delete", id);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void update(final AcademPerfomance academPerfomance) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("AcademPerfomance.update", academPerfomance);
		} finally {
			session.commit();
			session.close();
		}
	}

	public List<AcademPerfomance> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		List<AcademPerfomance> resultList = null;
		try {
			resultList = session.selectList("AcademPerfomance.selectAll");
		} finally {
			session.close();
		}
		return resultList;
	}

	public List<AcademPerfomance> selectByStudentAndSubject(final Student student,
			final Subject subject) {
		SqlSession session = sqlSessionFactory.openSession();
		List<AcademPerfomance> resultList = null;
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
	
	public List<AcademPerfomance> selectByStudentAndDate(final Student student,
			final LocalDate date) {
		SqlSession session = sqlSessionFactory.openSession();
		List<AcademPerfomance> resultList = null;
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
