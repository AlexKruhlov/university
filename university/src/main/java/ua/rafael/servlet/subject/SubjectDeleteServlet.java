package ua.rafael.servlet.subject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.service.SubjectService;

public class SubjectDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SubjectSession subjectSession = new SubjectSession(sessionFactory);
		SubjectService subjectService = new SubjectService(subjectSession);
		final long id = Long.valueOf(req.getParameter("deleteSubject"));
		subjectService.delete(id);
		resp.sendRedirect("/university/subjects");
	}
}
