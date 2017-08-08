package ua.rafael.service.validation;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.AcademPerfomanceSession;
import ua.rafael.model.AcademPerfomance;
import ua.rafael.service.AcademPerfomanceService;

public class AcademPerfomanceServiceValidator implements ServiceValidator<AcademPerfomance> {
	private AcademPerfomanceService academPerfomanceService;

	public AcademPerfomanceServiceValidator() {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		AcademPerfomanceSession academPerfomanceSession = new AcademPerfomanceSession(
				sessionFactory);
		academPerfomanceService = new AcademPerfomanceService(academPerfomanceSession);
	}

	@Override
	public void validateBySimilarObject(AcademPerfomance academPerfomance) {
		final AcademPerfomance foundAcademPerfomance = academPerfomanceService
				.findBy(academPerfomance.getStudent(), academPerfomance.getSubject(),
						academPerfomance.getDate());
		if (foundAcademPerfomance != null) {
			throw new RuntimeException("The academ perfomance item of the same student with "
					+ "the same subject and date already exists");
		}
	}
}
