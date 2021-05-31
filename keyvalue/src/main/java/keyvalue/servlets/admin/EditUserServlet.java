package keyvalue.servlets.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.config.Config;
import keyvalue.model.User;

@WebServlet("/admin/edit-user")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// get user id
			String userIdReq = (String) request.getParameter("id");
			Integer userId = Integer.parseInt(userIdReq);

			// get user properties from database

			User user = Config.daoUser.selectById(userId);
			// generate form with properties
			request.setAttribute("id", userId);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/admin/edit-user.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			request.setAttribute("error", "Parametro no válido.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (JdbcException e) {
			request.setAttribute("error", "El usuario no ha podido ser actualizado.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String userIdReq = (String) request.getParameter("id");
			Integer userId = Integer.parseInt(userIdReq);
			// get set properties from database
			User user = Config.daoUser.selectById(userId);
			// update properties
			String email = (String) request.getParameter("email");
			user.setEmail(email);
			String password = (String) request.getParameter("password");
			user.setPassword(password);
			String name = (String) request.getParameter("name");
			user.setName(name);
			String rol = (String) request.getParameter("rol");
			user.setRol(rol);
			// store update set in database
			Config.daoUser.update(user);
			request.setAttribute("message", "El usuario ha sido actualizado.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		} catch (NumberFormatException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (JdbcException e) {
			e.printStackTrace();
			// throw new RuntimeException(e);
			request.setAttribute("error", "El usuario no ha podido ser actualizado.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		}
	}

}
