package keyvalue.servlets.key;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.config.Config;
import keyvalue.model.Key;
import keyvalue.model.User;

@WebServlet("/set/addkey")
public class AddKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String setid = request.getParameter("setid");
		request.getRequestDispatcher("/set/addkey.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));
		// Check user logged in
		if (user == null) {
			request.setAttribute("error", "No tienes acceso a esta p�gina, logeate.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;

		}
		// get email/pass from form
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		String setId = request.getParameter("setid");
		if (setId != null) {
			Integer setOwnerId = Integer.parseInt(setId);

			try {
				// insert into database

				/*
				 * Some versions of java take microseconds and other milliseconds and this makes
				 * trouble when parsing the time
				 */
				LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
				Key k = new Key(null, setOwnerId, key, value, now.toString());

				Config.daoKey.insert(k);

				request.setAttribute("message", "La key ha sido creada con éxito.");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			} catch (JdbcException e) {
				e.printStackTrace();
				request.setAttribute("error", "Error insertando la key");
				request.getRequestDispatcher("/set/addkey.jsp").forward(request, response);
			}
		}

	}
}
