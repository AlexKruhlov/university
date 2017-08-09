package ua.rafael.servlet.student;

import static java.lang.Long.valueOf;
import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.StudentSession;
import ua.rafael.model.Student;
import ua.rafael.service.StudentService;

public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		StudentSession studentSession = new StudentSession(sessionFactory);
		StudentService studentService = new StudentService(studentSession);
		final long id = Long.valueOf(req.getParameter("updateSubjectId"));
		final String studentFirstName = req.getParameter("updateStudentFirstName");
		final String studentLastName = req.getParameter("updateStudentLastName");
		studentService.update(id, new Student(studentFirstName, studentLastName));
		resp.sendRedirect("/university/students");
	}

}
