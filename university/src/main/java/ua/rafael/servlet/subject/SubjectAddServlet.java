package ua.rafael.servlet.subject;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Subject;
import ua.rafael.service.SubjectService;

@WebServlet(urlPatterns = "/subjects/add")
public class SubjectAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final SqlSessionFactory sessionFactory = getSqlSessionFactory();
		final SubjectSession subjectSession = new SubjectSession(sessionFactory);
		final SubjectService subjectService = new SubjectService(subjectSession);
		final String subjectName = req.getParameter("addSubjectName");
		subjectService.insert(new Subject(subjectName));
		resp.sendRedirect("/university/subjects");
	}
}
