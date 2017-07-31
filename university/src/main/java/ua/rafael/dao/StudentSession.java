package ua.rafael.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.model.Mark;
import ua.rafael.model.Student;
import validator.StudentValidator;

public class StudentSession {
	private SqlSessionFactory sqlSessionFactory = null;

	public StudentSession(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void insert(final Student student) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Student.insert", student);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void delete(final int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Student.delete", id);
		} finally {
			session.commit();
			session.close();
		}
	}

	public void update(final Student student) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Student.delete", student);
		} finally {
			session.commit();
			session.close();
		}
	}
	
	public void selectAll(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Student.selectAll");
		} finally {
			session.close();
		}
	}
}
