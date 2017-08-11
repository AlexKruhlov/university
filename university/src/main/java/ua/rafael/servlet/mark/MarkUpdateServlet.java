package ua.rafael.servlet.mark;

import static java.lang.Integer.valueOf;
import static java.lang.Long.valueOf;
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

@WebServlet(urlPatterns = "/marks/update")
public class MarkUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		MarkSession markSession = new MarkSession(sessionFactory);
		MarkService markService = new MarkService(markSession);
		final long id = Long.valueOf(req.getParameter("updateMarkId"));
		final int markValue = Integer.valueOf(req.getParameter("updateMark"));
		RequestDispatcher view = req.getRequestDispatcher("/marks.jsp");
		try {
			markService.update(id, new Mark(markValue));
			resp.sendRedirect("/university/marks");
		} catch (RuntimeException e) {
			req.setAttribute("marks", markService.findAll());
			req.setAttribute("exception", e.getMessage());
			view.forward(req, resp);
		}
	}
}
