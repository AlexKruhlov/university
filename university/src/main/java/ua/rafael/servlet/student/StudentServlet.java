package ua.rafael.servlet.student;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.StudentSession;
import ua.rafael.model.Student;
import ua.rafael.service.StudentService;

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		StudentSession studentSession = new StudentSession(sessionFactory);
		StudentService studentService = new StudentService(studentSession);
		List<Student> students = studentService.findAll();
		req.setAttribute("students", students);
		RequestDispatcher view = req.getRequestDispatcher("students.jsp");
		view.forward(req, resp);
	}
}
