
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import keyvalue.dao.DaoUser;
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
			User user = new User(null, email, password);
			DaoUser.insert(user);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "Error insertando el usuario");
			request.getRequestDispatcher("/signup.jsp").forward(request, response);
		}
	}
}
