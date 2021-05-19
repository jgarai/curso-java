
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import keyvalue.dao.AccesoDatosException;
import keyvalue.dao.DaoUser;
import keyvalue.model.User;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("signin.jsp");
		request.getRequestDispatcher("/signin.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get data from request
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// fetch user from data base
		User user = new User();
		try {
			user = DaoUser.getUserByEmail(email);
			if (user == null) {
				throw new AccesoDatosException("El registro  de usuario no existe");
			}
			// compare if it matchs user data
			if (password.equals(user.getPassword())) {
				// save user into sesion and move to home
				HttpSession session = (HttpSession) request.getSession();
				session.setAttribute("user", user);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			} else {
				// if password does not match move again to sign in with an error msg
				request.setAttribute("error", "Usuario o contraseņa incorrectos");
				request.getRequestDispatcher("/signin.jsp").forward(request, response);
			}

		} catch (AccesoDatosException e) {
			System.out.println(e);
			request.setAttribute("error", "Usuario o contraseņa incorrectos");
			request.getRequestDispatcher("/signin.jsp").forward(request, response);
		}

	}

}
