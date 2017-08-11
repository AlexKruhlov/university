package ua.rafael.servlet.student;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.StudentSession;
import ua.rafael.model.Student;
import ua.rafael.service.StudentService;
import validation.StudentValidator;
import validation.SubjectValidator;

@WebServlet(urlPatterns = "/students/add")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		StudentSession studentSession = new StudentSession(sessionFactory);
		StudentService studentService = new StudentService(studentSession);
		final String studentFirstName = req.getParameter("addStudentFirstName");
		final String studentLastName = req.getParameter("addStudentLastName");
		final Student student = new Student(studentFirstName, studentLastName);
		RequestDispatcher view  = req.getRequestDispatcher("/students.jsp");
		try {
			studentService.insert(student);
			resp.sendRedirect("/university/students");
		} catch (RuntimeException e) {
			req.setAttribute("students", studentService.findAll());
			req.setAttribute("exception", e.getMessage());
			view.forward(req, resp);
		}		
	}
}
