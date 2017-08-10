package validation;

import static validation.ValidatorUtil.checkForSymbols;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.StudentSession;
import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;
import ua.rafael.service.StudentService;
import ua.rafael.service.SubjectService;

public class StudentValidator implements Validator<Student> {

	@Override
	public void validate(final Student student) {
		checkForInvalideNameSymbol(student);
		checkForSimilarStudent(student);
	}

	private void checkForInvalideNameSymbol(final Student student) {
		final String symbolsForHumanName = "[a-zA-Z-]*+";
		if (!checkForSymbols(symbolsForHumanName, student.getFirstName())) {
			throw new RuntimeException("Incorrect symbol for first name was found");
		}
		if (!checkForSymbols(symbolsForHumanName, student.getLastName())) {
			throw new RuntimeException("Incorrect symbol for last name was found");
		}
	}

	private void checkForSimilarStudent(final Student student) {
		SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		StudentSession studentSession = new StudentSession(sessionFactory);
		StudentService studentService = new StudentService(studentSession);
		final Student foundStudent = studentService.findByName(student.getFirstName(), student.getLastName());
		if (foundStudent != null) {
			throw new RuntimeException("The same student already exists");
		}
	}
	
	
}
