package ua.rafael.servlet.subject;

import static java.lang.Long.valueOf;
import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.SubjectSession;
import ua.rafael.model.Subject;
import ua.rafael.service.SubjectService;

@WebServlet(urlPatterns = "/subjects/update")
public class SubjectUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SubjectSession subjectSession = new SubjectSession(sessionFactory);
		SubjectService subjectService = new SubjectService(subjectSession);
		final long id = valueOf(req.getParameter("updateSubjectId"));
		final String newSubjectName = req.getParameter("updateSubjectName");
		RequestDispatcher view = req.getRequestDispatcher("/subjects.jsp");
		try {
			subjectService.update(id, newSubjectName);
			resp.sendRedirect("/university/subjects");
		} catch (RuntimeException e) {
			req.setAttribute("subjects", subjectService.findAll());
			req.setAttribute("exception", e.getMessage());
			view.forward(req, resp);
		}
	}
}
