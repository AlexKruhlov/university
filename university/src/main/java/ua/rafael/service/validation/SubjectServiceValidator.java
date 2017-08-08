package ua.rafael.service.validation;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Subject;
import ua.rafael.service.SubjectService;

public class SubjectServiceValidator implements ServiceValidator<Subject> {
	private SubjectService subjectService;

	public SubjectServiceValidator() {
		SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SubjectSession subjectSession = new SubjectSession(sessionFactory);
		subjectService = new SubjectService(subjectSession);
	}

	@Override
	public void validateBySimilarObject(Subject object) {
		final Subject foundSubject = subjectService.findByName(object.getName());
		if (foundSubject != null) {
			throw new RuntimeException("The same subject already exists");
		}
	}
}
