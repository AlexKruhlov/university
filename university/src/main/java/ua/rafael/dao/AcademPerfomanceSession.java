package ua.rafael.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.model.AcademPerfomance;

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
	
