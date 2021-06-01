package keyvalue.servlets.key;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.config.Config;
import keyvalue.model.Key;

@WebServlet("/set/list-keys")
public class ListKeysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String setid = request.getParameter("setid");
		try {
			// show set's keys

			List<Key> keys = Config.daoKey.selectAllByField("set_owner_id", Integer.parseInt(setid));

			request.setAttribute("keys", keys);
			request.getRequestDispatcher("/set/list-keys.jsp").forward(request, response);
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
