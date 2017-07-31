package ua.rafael.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.model.Subject;

public class SubjectSession {
	private SqlSessionFactory sqlSessionFactory = null;

	public SubjectSession(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

//	public int createTable() {
//		int rowsCount = 0;
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			session.update("Subject.createTable");
//		} finally {
//			session.commit();
//			session.close();
//		}
//		return rowsCount;
//	}

	public void insert(final Subject subject) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Subject.insert", subject);
		} finally {
			session.commit();
			session.close();
		}
	}

	public List<Subject> selectAll() {
		List<Subject> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("Subject.selectAll");
		} finally {
			session.close();
		}
		return list;
	}

	public void update(final Subject subject) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("Subject.update", subject);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void delete(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("Subject.delete", id);
		} finally {
			session.commit();
			session.close();
		}
	}

//	public void dropTable() {
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			session.update("Subject.dropTable");
//		} finally {
//			session.commit();
//			session.close();
//		}
//	}
}
