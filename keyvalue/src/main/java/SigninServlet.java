
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("signin.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String emailSession = request.getSession().getAttribute("email").toString();
		String passwordSession = request.getSession().getAttribute("password").toString();

		if (emailSession.equals(email) && passwordSession.equals(password)) {

			response.sendRedirect("home.jsp");
		} else {
			request.setAttribute("error", "Usuario o contraseña incorrectos");
			request.getRequestDispatcher("/signin.jsp").forward(request, response);
		}

	}

}
