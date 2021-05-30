package keyvalue.servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.config.Config;
import keyvalue.model.User;

@WebServlet("/admin/list-users")
public class ListUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));
		// Check user if logged in // probably it is not necessary because of filters
		if (user == null) {
			request.setAttribute("error", "No tienes acceso a dashboard, logeate.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;

		}
		try {
			// show users
			List<User> users = Config.daoUser.select();
			request.setAttribute("users", users);

			request.getRequestDispatcher("/admin/list-users.jsp").forward(request, response);
		} catch (JdbcException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));
		// Check user logged in // probably it is not necessary because of filters
		if (user == null) {
			request.setAttribute("error", "No tienes acceso a dashboard, logeate.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;

		}

	}

}
