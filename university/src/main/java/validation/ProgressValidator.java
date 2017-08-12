package validation;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.PogressSession;
import ua.rafael.model.Progress;
import ua.rafael.service.ProgressService;

public class ProgressValidator implements Validator<Progress> {
	SqlSessionFactory sessionFactory = getSqlSessionFactory();
	ProgressService progressService = new ProgressService(
			new PogressSession(sessionFactory));

	@Override
	public void validate(Progress progress) {
		if (progress.getStudent() == null) {
			throw new RuntimeException("Cannot find this student");
		} else if (progress.getSubject() == null) {
			throw new RuntimeException("Cannot find this subject");
		} else if (progress.getMark() == null) {
			throw new RuntimeException("Cannot find this mark");
		}
		checkForSimilarProgressItem(progress);
	}

	private void checkForSimilarProgressItem(final Progress progress) {
		Progress progressFromDB = progressService.findBy(
				progress.getStudent(), progress.getSubject(),
				progress.getDate());
		if (progressFromDB != null) {
			throw new RuntimeException("This progress item already exists");
		}
	}
}
