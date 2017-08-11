package ua.rafael.servlet.acadperfomance;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.AcademPerfomanceSession;
import ua.rafael.service.AcademPerfomanceService;

@WebServlet(urlPatterns = "/acad-perfomance")
public class AcademPerfomanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		AcademPerfomanceSession academPerfomanceSession = new AcademPerfomanceSession(
				sessionFactory);
		AcademPerfomanceService academPerfomanceService = new AcademPerfomanceService(
				academPerfomanceSession);
		RequestDispatcher view = req.getRequestDispatcher("/acad-perfomance.jsp");
		view.forward(req, resp);
	}
}
