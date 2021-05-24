package keyvalue.servlets.set;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * Servlet implementation class SetsServlet
 */
@WebServlet("/sets")
public class SetsServlet extends HttpServlet {
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
		try {
			// show user's sets
			// TODO copy sets
			List<Myset> setsAux = Config.daoSet.select();
			List<Myset> sets = new ArrayList<>();
			Integer owner, id;
			for (Myset s : setsAux) {
				owner = s.getOwner_id();
				id = user.getId();
				System.out.println(owner);
				System.out.println(id);
				if (owner == id) {
					sets.add(s);
				}

			}
			System.out.println(sets);

			request.setAttribute("sets", sets);

			request.getRequestDispatcher("/sets.jsp").forward(request, response);
		} catch (JdbcException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
