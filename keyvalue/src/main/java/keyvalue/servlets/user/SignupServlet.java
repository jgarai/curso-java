package keyvalue.servlets.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.AccesoDatosException;
import keyvalue.dao.config.Config;
import keyvalue.model.User;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get email/pass from form
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// insert into database
		try {
			// OLD CODE / User user = new User(null, email, password);
			// OLD CODE / user = Config.daoUser.selectOneByField("email", email);
			// OLD CODE / DaoUser.insert(user);
			User user = new User(null, email, password, null);
			Config.daoUser.insert(user);

			request.setAttribute("message", "El usuario ha sido creado con �xito.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (JdbcException e) {
			e.printStackTrace();

			request.setAttribute("error", "Error insertando el usuario");
			request.getRequestDispatcher("/signup.jsp").forward(request, response);
		} catch (AccesoDatosException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("error", "Error insertando el usuario");
			request.getRequestDispatcher("/signup.jsp").forward(request, response);
		}
	}
}
