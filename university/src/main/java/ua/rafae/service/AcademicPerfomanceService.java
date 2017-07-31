package ua.rafae.service;

import ua.rafael.dao.StudentSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Mark;
import ua.rafael.model.Student;
import validator.MarkValidator;
import validator.StudentValidator;

public class AcademicPerfomanceService {
	private StudentSession studentDao = new StudentSession(MyBatisConnectionFactory.getSqlSessionFactory());
	
}
