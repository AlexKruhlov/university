package ua.rafael.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.model.Mark;

public class MarkSession {
	private SqlSessionFactory sqlSessionFactory = null;

	public MarkSession(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void createTable() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Mark.createTable");
		} finally {
			session.commit();
			session.close();
		}
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

	public void delete(final long id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("Mark.delete", id);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void update(final Mark mark) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("Mark.update", mark);
		} finally {
			session.commit();
			session.close();
		}
	}

	public List<Mark> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Mark> resultList = null;
		try {
			resultList = session.selectList("Mark.selectAll");
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public Mark selectById(final long id) {
		Mark result = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.selectOne("Mark.selectById", id);
		} finally {
			session.close();
		}
		return result;
	}

	public void dropTable() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("Mark.dropTable");
		} finally {
			session.commit();
			session.close();
		}
	}
}
