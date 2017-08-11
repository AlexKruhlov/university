package validation;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.MarkSession;
import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Mark;
import ua.rafael.model.Subject;
import ua.rafael.service.MarkService;
import ua.rafael.service.SubjectService;

public class MarkValidator implements Validator<Mark> {

	@Override
	public void validate(final Mark mark) {
		//checkDateRange(mark.getDate());
		checkMarkRange(mark.getValue());
		checkForSimilarMark(mark);
	}

	public void checkDateRange(LocalDate date) {
		if (!(date.isEqual(LocalDate.now()) || date.isBefore(LocalDate.now()))) {
			throw new DateTimeException("[ERROR]: Date must not be in future");
		}
	}

	private void checkMarkRange(final int markValue) {
		if (markValue <= 0) {
			throw new RuntimeException("Mark must not be negative digit");
		}
	}
	
	private void checkForSimilarMark(final Mark mark) {
		SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		MarkSession markSession = new MarkSession(sessionFactory);
		MarkService markService = new MarkService(markSession);
		final Mark foundMark = markService.findByValue(mark.getValue());
		if (foundMark != null) {
			throw new RuntimeException("The same mark already exists");
		}
	}
}
