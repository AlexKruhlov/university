package ua.rafael.servlet.mark;

import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.MarkSession;
import ua.rafael.model.Mark;
import ua.rafael.service.MarkService;

@WebServlet(urlPatterns = "/marks")
public class MarkServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		MarkSession markSession = new MarkSession(sessionFactory);
		MarkService markService = new MarkService(markSession);
		List<Mark> marks = markService.findAll();
		req.setAttribute("marks", marks);
		RequestDispatcher view = req.getRequestDispatcher("marks.jsp");
		view.forward(req, resp);
	}
}
