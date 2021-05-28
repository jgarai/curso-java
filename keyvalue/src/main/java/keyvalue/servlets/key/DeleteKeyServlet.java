package keyvalue.servlets.key;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.config.Config;

@WebServlet("/set/delete-key")
public class DeleteKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteKeyServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String keyId = request.getParameter("keyid");
		try {
			Config.daoKey.delete(Integer.parseInt(keyId));
			request.setAttribute("message", "La key ha podido borrarse con éxito.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		} catch (JdbcException e) {
			request.setAttribute("error", "No se ha podido borrar la key.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			request.setAttribute("error", "El parametro no es correcto borrando la key.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
