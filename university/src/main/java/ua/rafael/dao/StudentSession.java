package ua.rafael.dao;

import java.awt.MenuComponent;
import java.awt.Stroke;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Student selectByName(final String firstName, final String lastName) {
		Student result = null;
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, String> map = new HashMap<>();
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		try {
			result = session.selectOne("Student.selectByName", map);
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
