package ua.rafael.servlet.subject;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet(urlPatterns = "/subjects")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SubjectSession subjectSession = new SubjectSession(sessionFactory);
		SubjectService subjectService = new SubjectService(subjectSession);
		List<Subject> subjects = subjectService.findAll();
		req.setAttribute("subjects", subjects);
		RequestDispatcher view = req.getRequestDispatcher("subjects.jsp");
		view.forward(req, resp);
	}	
}
