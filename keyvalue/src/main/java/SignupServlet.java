
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import keyvalue.dao.DaoUser;
import keyvalue.entidades.User;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("signup.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get email/pass from form
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// insert into data base
		try {
			User u = new User(null, email, password);
			DaoUser.insert(u);
		} catch (Exception e) {

			System.out.println(e);

		}

		request.getSession().setAttribute("email", email);
		request.getSession().setAttribute("password", password);

		response.sendRedirect("home.jsp");
	}

}
