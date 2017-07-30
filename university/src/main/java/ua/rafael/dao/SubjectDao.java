package ua.rafael.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.model.Subject;

public class SubjectDao {
	private SqlSessionFactory sqlSessionFactory = null;

	public SubjectDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public void createTable(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("Subject.createTable");
		} finally {
			session.commit();
			session.close();
		}
	}
	
	public void insert(final Subject subject){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Subject.insert",subject);
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
	
	public void dropTable(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("Subject.dropTable");
		} finally {
			session.commit();
			session.close();
		}
	}
}
