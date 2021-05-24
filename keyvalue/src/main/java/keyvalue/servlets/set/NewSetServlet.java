package keyvalue.servlets.set;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.config.Config;
import keyvalue.model.Myset;
import keyvalue.model.User;

@WebServlet("/set/newset")
public class NewSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));
		// Check user logged in
		if (user == null) {
			request.setAttribute("error", "No tienes acceso a esta página, logeate.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;

		}
		request.getRequestDispatcher("/set/newset.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));
		// Check user logged in
		if (user == null) {
			request.setAttribute("error", "No tienes acceso a esta página, logeate.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;

		}
		String setName = request.getParameter("setname");
		String setDescription = request.getParameter("setdescription");

		try {
			// insert into database
			Myset set = new Myset(null, user.getId(), setName, setDescription);
			Config.daoSet.insert(set);

			request.setAttribute("message", "El set ha sido creado con éxito.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (JdbcException e) {
			e.printStackTrace();
			request.setAttribute("error", "Error insertando el set");
			request.getRequestDispatcher("/set/newset.jsp").forward(request, response);

		}

	}

}
