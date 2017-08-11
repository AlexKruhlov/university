package validation;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.AcademPerfomanceSession;
import ua.rafael.model.AcademPerfomance;
import ua.rafael.service.AcademPerfomanceService;

public class AcademPerfomanceValidator implements Validator<AcademPerfomance> {
	SqlSessionFactory sessionFactory = getSqlSessionFactory();
	AcademPerfomanceService academPerfomanceService = new AcademPerfomanceService(
			new AcademPerfomanceSession(sessionFactory));

	@Override
	public void validate(AcademPerfomance academPerfomance) {
		if (academPerfomance.getStudent() == null) {
			throw new RuntimeException("Cannot find this student");
		} else if (academPerfomance.getSubject() == null) {
			throw new RuntimeException("Cannot find this subject");
		} else if (academPerfomance.getMark() == null) {
			throw new RuntimeException("Cannot find this mark");
		}
		checkForSimilarAcademPerfomanceItem(academPerfomance);
	}

	private void checkForSimilarAcademPerfomanceItem(final AcademPerfomance academPerfomance) {
		AcademPerfomance academPerfomanceFromDB = academPerfomanceService.findBy(
				academPerfomance.getStudent(), academPerfomance.getSubject(),
				academPerfomance.getDate());
		if (academPerfomanceFromDB != null) {
			throw new RuntimeException("This academ perfomance item already exists");
		}
	}
}
