package ua.rafael.service.validation;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.StudentSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Student;
import ua.rafael.service.StudentService;

public class StudentServiceValidator implements ServiceValidator<Student> {
	private StudentService studentService;

	public StudentServiceValidator() {
		SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		StudentSession studentSession = new StudentSession(sessionFactory);
		studentService = new StudentService(studentSession);
	}

	@Override
	public void validateBySimilarObject(final Student student) {
		final Student foundStudent = studentService.findByName(student.getFirstName(),
				student.getLastName());
		if (foundStudent != null) {
			throw new RuntimeException("The same student already exists");
		}
	}
}
