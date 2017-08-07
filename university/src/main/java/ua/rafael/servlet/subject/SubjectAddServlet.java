package ua.rafael.servlet.subject;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.model.Subject;
import ua.rafael.service.SubjectService;

public class SubjectAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SubjectSession subjectSession = new SubjectSession(sessionFactory);
		SubjectService subjectService = new SubjectService(subjectSession);
		String subjectName = req.getParameter("inputSubject");
		subjectService.insert(new Subject(subjectName));
		resp.sendRedirect("/university/subjects");
	}
}
