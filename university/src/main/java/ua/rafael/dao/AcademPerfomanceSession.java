package ua.rafael.dao;

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
			session.insert("AcademPerfomance.delete", academPerfomance);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("AcademPerfomance.selectAll");
		} finally {
			session.close();
		}
	}
}
	
