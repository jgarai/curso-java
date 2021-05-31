package keyvalue.servlets.key;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.config.Config;
import keyvalue.model.Key;

@WebServlet("/set/edit-key")
public class EditKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// get key id
			String keyIdReq = (String) request.getParameter("keyid");
			Integer keyId = Integer.parseInt(keyIdReq);

			// get key properties from database

			Key key = Config.daoKey.selectById(keyId);
			// generate form with properties
			request.setAttribute("keyid", keyId);
			request.setAttribute("key", key);
			request.getRequestDispatcher("/set/edit-key.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (JdbcException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String keyIdReq = (String) request.getParameter("keyid");
			Integer keyId = Integer.parseInt(keyIdReq);
			// get set properties from database
			Key key = Config.daoKey.selectById(keyId);
			// update properties
			String keyKeyReq = (String) request.getParameter("key");
			key.setKey(keyKeyReq);
			String keyValueReq = (String) request.getParameter("value");
			key.setValue(keyValueReq);
			// store update set in database
			Config.daoKey.update(key);
			request.setAttribute("message", "La key ha sido actualizada.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		} catch (NumberFormatException e) {

			request.setAttribute("error", "Parametro no válido.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (JdbcException e) {

			request.setAttribute("error", "La key no ha podido ser actualizada.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		}
	}

}
