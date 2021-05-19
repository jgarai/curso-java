
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import keyvalue.dao.DaoUser;
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
		}
		request.getRequestDispatcher("/dashboard.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));
		if (user == null) {
			request.setAttribute("error", "No tienes acceso a dashboard, logeate.");
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
		}

		String DeleteUser = request.getParameter("delete");
		if (DeleteUser.equals("true")) {
			try {
				Integer id = user.getId();
				DaoUser.delete(id);
				session.invalidate();

				request.setAttribute("message", "Tu usuario ha sido borrado de la base de datos");
				request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("error", "Ha habido un error borrando tu usuario");
				request.getRequestDispatcher("/dashboard.jsp").forward(request, response);

			}

		}

	}

}
