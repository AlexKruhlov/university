package ua.rafael.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.model.Student;

public class StudentSession {
	private SqlSessionFactory sqlSessionFactory = null;

	public StudentSession(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void createTable() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Student.createTable");
		} finally {
			session.commit();
			session.close();
		}
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

	public void delete(final long id) {
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
			session.update("Student.update", student);
		} finally {
			session.commit();
			session.close();
		}
	}

	public List<Student> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Student> resultList = null;
		try {
			resultList = session.selectList("Student.selectAll");
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public Student selectById(final long id) {
		Student result = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			result = session.selectOne("Student.selectById", id);
		} finally {
			session.close();
		}
		return result;
	}
	
	public void dropTable() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("Student.dropTable");
		} finally {
			session.commit();
			session.close();
		}
	}
}
