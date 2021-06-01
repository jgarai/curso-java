package keyvalue.servlets.set;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.config.Config;

@WebServlet("/set/delete-set")
public class DeleteSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		doGet(request, response);
	}

}
