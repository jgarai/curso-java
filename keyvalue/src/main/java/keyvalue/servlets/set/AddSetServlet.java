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

@WebServlet("/set/add-set")
public class AddSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));

		try {
			// fetch user's sets. The numbers of sets should be less than 10

			List<Myset> sets = Config.daoSet.selectAllByField("owner_id", user.getId());

			if (sets != null && sets.size() <= 8) {

				request.getRequestDispatcher("/set/add-set.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "El numero maximo de sets por usuario es 10.");
				request.getRequestDispatcher("/message.jsp").forward(request, response);

			}
		} catch (JdbcException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
		User user = ((User) session.getAttribute("user"));

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
			request.getRequestDispatcher("/set/add-set.jsp").forward(request, response);

		}

	}

}
