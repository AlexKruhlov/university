package validation;

import static validation.ValidatorUtil.checkForSymbols;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Subject;
import ua.rafael.service.SubjectService;

public class SubjectValidator implements Validator<Subject> {

	@Override
	public void validate(final Subject subject) {
		checkForInvalideSymbols(subject);
		checkForSimilarSubject(subject);
	}

	private void checkForInvalideSymbols(final Subject subject) {
		final String regexpPattern = "[a-zA-Z ]*+";
		if (!checkForSymbols(regexpPattern, subject.getName())) {
			throw new RuntimeException(
					"Invalide symbol. All symbols must be letters or underscore sign");
		}
	}

	private void checkForSimilarSubject(final Subject subject) {
		SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SubjectSession subjectSession = new SubjectSession(sessionFactory);
		SubjectService subjectService = new SubjectService(subjectSession);
		final Subject foundSubject = subjectService.findByName(subject.getName());
		if (foundSubject != null) {
			throw new RuntimeException("The same subject already exists");
		}
	}
}
