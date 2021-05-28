package keyvalue.servlets.set;

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
import keyvalue.model.Myset;
import keyvalue.model.User;

@WebServlet("/set/list-sets")
public class ListSetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));

		try {
			// show user's sets

			List<Myset> sets = Config.daoSet.selectAllByField("owner_id", user.getId());

			request.setAttribute("sets", sets);
			request.getRequestDispatcher("/set/list-sets.jsp").forward(request, response);
		} catch (JdbcException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
