package keyvalue.servlets.admin;

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

@WebServlet("/admin/user/delete")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));
		// Check user if logged in // probably it is not necesary because of filters
		if (user == null) {
			request.setAttribute("error", "No tienes acceso a dashboard, logeate.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;

		}
		try {

			Integer userId = Integer.parseInt((String) request.getParameter("id"));

			Config.daoUser.delete(userId);
			request.setAttribute("message", "El usuario ha sido eliminado con éxito.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		} catch (JdbcException e) {
			request.setAttribute("error", "No pudo eliminarse el usuario");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			e.printStackTrace();

		} catch (NumberFormatException e) {
			request.setAttribute("error", "No pudo eliminarse el usuario, parametro incorrecto");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			e.printStackTrace();

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
