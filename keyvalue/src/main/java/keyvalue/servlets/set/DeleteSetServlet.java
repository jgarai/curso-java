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
import keyvalue.model.User;

@WebServlet("/set/delete")
public class DeleteSetServlet extends HttpServlet {
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
		String setId = request.getParameter("setid");
		try {
			Config.daoSet.delete(Integer.parseInt(setId));
			request.setAttribute("message", "El set ha podido borrarse con éxito.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		} catch (JdbcException e) {
			request.setAttribute("error", "No se ha podido borrar el set.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			request.setAttribute("error", "El parametro no es correcto borrando el set.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
