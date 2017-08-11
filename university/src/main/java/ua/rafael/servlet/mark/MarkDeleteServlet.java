package ua.rafael.servlet.mark;

import static java.lang.Long.valueOf;
import static ua.rafael.data.MyBatisConnectionFactory.getSqlSessionFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import ua.rafael.dao.MarkSession;
import ua.rafael.service.MarkService;

@WebServlet(urlPatterns = "/marks/delete")
public class MarkDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		MarkSession markSession = new MarkSession(sessionFactory);
		MarkService markService = new MarkService(markSession);
		final long id = valueOf(req.getParameter("deleteMark"));
		markService.delete(id);
		resp.sendRedirect("/university/marks");
	}
}
