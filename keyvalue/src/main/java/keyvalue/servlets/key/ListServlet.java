package keyvalue.servlets.key;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/set/list")
public class ListServlet extends HttpServlet {
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

		String setid = request.getParameter("setid");
		try {
			// show user's sets

			List<Key> keys = Config.daoKey.selectAllByField("setOwnerId", Integer.parseInt(setid));

			request.setAttribute("keys", keys);
			request.getRequestDispatcher("/sets.jsp").forward(request, response);
		} catch (JdbcException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/set/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
