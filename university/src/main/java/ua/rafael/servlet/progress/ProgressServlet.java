package ua.rafael.servlet.progress;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.PogressSession;
import ua.rafael.service.ProgressService;

@WebServlet(urlPatterns = "/progress")
public class ProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		PogressSession progressSession = new PogressSession(
				sessionFactory);
		ProgressService progressService = new ProgressService(
				progressSession);
		RequestDispatcher view = req.getRequestDispatcher("/progress.jsp");
		view.forward(req, resp);
	}
}
