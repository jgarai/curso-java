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

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		// get email/pass from form
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			// insert into database
			User user = new User(null, email, password, null, "USER");
			Config.daoUser.insert(user);
			// recall user from db and store it into the session
			user = Config.daoUser.selectOneByField("email", email);
			HttpSession session = (HttpSession) request.getSession();
			session.setAttribute("user", user);

			request.setAttribute("message", "El usuario ha sido creado con éxito.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (JdbcException e) {
			e.printStackTrace();
			request.setAttribute("error", "Error insertando el usuario");
			request.getRequestDispatcher("/signup.jsp").forward(request, response);

		}
	}
}
