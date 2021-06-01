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
//import keyvalue.dao.DaoUser;
import keyvalue.model.User;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/signin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		// get data from request
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// fetch user from data base
		User user = new User();
		try {
			// user = DaoUser.getUserByEmail(email);
			user = Config.daoUser.selectOneByField("email", email);

			if (user == null) {
				throw new JdbcException("El registro  de usuario no existe");
			}
			// compare if it matches user data
			if (password.equals(user.getPassword())) {
				// save user into session and move to home
				HttpSession session = (HttpSession) request.getSession();
				session.setAttribute("user", user);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			} else {
				// if password does not match move again to sign in with an error msg
				request.setAttribute("error", "Usuario o contraseña incorrectos");
				request.getRequestDispatcher("/WEB-INF/root.jsp").forward(request, response);
			}

		} catch (JdbcException e) {
			request.setAttribute("error", "Usuario o contrase�a incorrectos");
			request.getRequestDispatcher("/signin.jsp").forward(request, response);
		}

	}

}
