package ua.rafael.servlet.progress;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.PogressSession;
import ua.rafael.dao.SubjectSession;
import ua.rafael.model.Progress;
import ua.rafael.model.Mark;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;
import ua.rafael.service.ProgressService;
import ua.rafael.service.SubjectService;

@WebServlet(urlPatterns = "/progress/add")
public class ProgressAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final SqlSessionFactory sessionFactory = getSqlSessionFactory();
		final PogressSession progressSession = new PogressSession(
				sessionFactory);
		final ProgressService progressService = new ProgressService(
				progressSession);
		final String firstName = req.getParameter("addFirstName");
		final String lastName = req.getParameter("addLastName");
		final Student student = new Student(firstName, lastName);
		final int markValue = Integer.valueOf(req.getParameter("addMarkValue"));
		final Mark mark = new Mark(markValue);
		final String subjectName = req.getParameter("addSubject");
		final Subject subject = new Subject(subjectName);
		final LocalDate date = LocalDate.parse(req.getParameter("addDate"));
		final Progress progress = new Progress(student, subject, date,
				mark);
	
		RequestDispatcher view = req.getRequestDispatcher("/progress.jsp");
		try {
			progressService.insert(progress);
		} catch (RuntimeException e) {
			final SubjectSession subjectSession = new SubjectSession(sessionFactory);
			final SubjectService subjectService = new SubjectService(subjectSession);
			req.setAttribute("subjects", subjectService.findAll());
			req.setAttribute("exception", e.getMessage());
			view.forward(req, resp);
		}
	}
}
