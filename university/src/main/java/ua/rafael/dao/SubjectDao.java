package ua.rafael.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.postgresql.util.LruCache.CreateAction;

import ua.rafael.model.Subject;

public class SubjectDao {
	private SqlSessionFactory sqlSessionFactory = null;

	public SubjectDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public void createTable() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.selectList("Subject.selectAll");
		} finally {
			session.close();
		}
		return list;
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
}
