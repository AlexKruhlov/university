package ua.rafael.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.model.Mark;
import ua.rafael.model.Student;

public class MarkSession {
	private SqlSessionFactory sqlSessionFactory = null;

	public MarkSession(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void insert(final Mark mark) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Mark.insert", mark);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void delete(final int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Mark.delete", id);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void update(final Mark mark) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Mark.delete", mark);
		} finally {
			session.commit();
			session.close();
		}
	}
	
	public void selectAll(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Mark.selectAll");
		} finally {
			session.close();
		}
	}
}
