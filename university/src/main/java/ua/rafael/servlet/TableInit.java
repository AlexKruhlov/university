package ua.rafael.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.PogressSession;
import ua.rafael.dao.MarkSession;
import ua.rafael.dao.StudentSession;
import ua.rafael.dao.SubjectSession;
import ua.rafael.data.MyBatisConnectionFactory;
import ua.rafael.service.ProgressService;
import ua.rafael.service.MarkService;
import ua.rafael.service.StudentService;
import ua.rafael.service.SubjectService;

@WebServlet(urlPatterns = "/tables/init")
public class TableInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SqlSessionFactory sessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		ProgressService progressService = new ProgressService(
				new PogressSession(sessionFactory));
		StudentService studentService = new StudentService(new StudentSession(sessionFactory));
		SubjectService subjectService = new SubjectService(new SubjectSession(sessionFactory));
		MarkService markService = new MarkService(new MarkSession(sessionFactory));
		studentService.createTable();
		subjectService.createTable();
		markService.createTable();
		progressService.createTable();
		resp.sendRedirect("/university/students");
	}
}
