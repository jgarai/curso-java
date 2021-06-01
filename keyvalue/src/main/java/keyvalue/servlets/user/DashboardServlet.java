package keyvalue.servlets.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.config.Config;
import keyvalue.model.User;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));
		if (user == null) {
			request.setAttribute("error", "No tienes acceso a dashboard, logeate.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/dashboard.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));
		if (user == null) {
			request.setAttribute("error", "No tienes acceso a dashboard, logeate.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		// delete user
		String DeleteUser = request.getParameter("delete");
		if (DeleteUser != null && DeleteUser.equals("true")) {
			try {
				Integer id = user.getId();
				Config.daoUser.delete(id);
				session.invalidate();
				request.setAttribute("message", "Tu usuario ha sido borrado de la base de datos");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			} catch (JdbcException e) {
				request.setAttribute("error", "Ha habido un error borrando tu usuario");
				request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			}

		}
		// rename user
		String newName = request.getParameter("change_name");
		if (newName != null) {
			try {
				user.setName(newName);
				Config.daoUser.update(user);
				session.setAttribute("user", user);
				request.setAttribute("message", "Tu usuario ha sido renombrado.");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			} catch (JdbcException e) {
				request.setAttribute("error", "Ha habido un error renombrando tu usuario");
				request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			}
		}
	}

}
