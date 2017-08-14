package ua.rafael.servlet.progress;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.MarkSession;
import ua.rafael.dao.PogressSession;
import ua.rafael.dao.StudentSession;
import ua.rafael.dao.SubjectSession;
import ua.rafael.model.Progress;
import ua.rafael.model.Mark;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;
import ua.rafael.service.MarkService;
import ua.rafael.service.ProgressService;
import ua.rafael.service.StudentService;
import ua.rafael.service.SubjectService;

@WebServlet(urlPatterns = "/progress/add")
public class ProgressAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final SqlSessionFactory sessionFactory = getSqlSessionFactory();
		final long subjectId = Long.valueOf(req.getParameter("addSubject"));
		final SubjectSession subjectSession = new SubjectSession(sessionFactory);
		final SubjectService subjectService = new SubjectService(subjectSession);
		final Subject subject = subjectService.findById(subjectId);
		final long studentId = Long.valueOf(req.getParameter("addStudent"));
		final StudentSession studentSession = new StudentSession(sessionFactory);
		final StudentService studentService = new StudentService(studentSession);
		final Student student = studentService.findById(studentId);
		final long markId = Long.valueOf(req.getParameter("addMark"));
		final MarkSession markSession = new MarkSession(sessionFactory);
		final MarkService markService = new MarkService(markSession);
		final Mark mark = markService.findById(markId);
		final LocalDate date = LocalDate.parse(req.getParameter("addDate"));
		final Progress progress = new Progress(student, subject, date, mark);
		final PogressSession progressSession = new PogressSession(sessionFactory);
		final ProgressService progressService = new ProgressService(progressSession);
		try {
			progressService.insert(progress);
			resp.sendRedirect("/university/progress");
		} catch (RuntimeException e) {
			req.setAttribute("subjects", subjectService.findAll());
			req.setAttribute("exception", e.getMessage());
			req.getRequestDispatcher("/progress.jsp").forward(req, resp);
		}
	}
}
