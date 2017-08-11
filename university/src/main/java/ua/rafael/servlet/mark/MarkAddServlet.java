package ua.rafael.servlet.mark;

import static java.lang.Integer.valueOf;
import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;

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


@WebServlet(urlPatterns = "/marks/add")
public class MarkAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final SqlSessionFactory sessionFactory = getSqlSessionFactory();
		final MarkSession markSession = new MarkSession(sessionFactory);
		final MarkService markService = new MarkService(markSession);
		final int markName = valueOf(req.getParameter("addMark"));
		final Mark mark = new Mark(markName);
		RequestDispatcher view  = req.getRequestDispatcher("/marks.jsp");
		try {
			markService.insert(mark);
			resp.sendRedirect("/university/marks");
		} catch (RuntimeException e) {
			req.setAttribute("marks", markService.findAll());
			req.setAttribute("exception", e.getMessage());
			view.forward(req, resp);
		}
	}
}
