package ua.rafae.service;

import ua.rafael.dao.StudentDao;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Mark;
import ua.rafael.model.Student;
import validator.MarkValidator;
import validator.StudentValidator;

public class StrudentSqlService {
	private Student student;
	private StudentDao studentDao = new StudentDao(MyBatisConnectionFactory.getSqlSessionFactory());
	
	public void addMark(final Mark mark) {
		new MarkValidator().validate(mark);
		student.getMarks().add(mark);
		student.getMarks().add(mark);
		new StudentValidator().validate(student);
		studentDao.insert(mark);
	}
}
