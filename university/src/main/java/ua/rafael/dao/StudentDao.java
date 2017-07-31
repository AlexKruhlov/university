package ua.rafael.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.model.Mark;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory = null;

	public StudentDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public void insert(final Mark mark) {
		
	}
}
