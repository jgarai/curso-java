package keyvalue.servlets.set;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eskura21.libraries.beginnersjdbc.JdbcException;

import keyvalue.dao.config.Config;
import keyvalue.model.Myset;

@WebServlet("/set/edit-set")
public class EditSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// get set id
			String setIdReq = (String) request.getParameter("setid");
			Integer setId = Integer.parseInt(setIdReq);
			// get set properties from database
			Myset set = Config.daoSet.selectById(setId);
			// generate form with properties
			request.setAttribute("setid", setId);
			request.setAttribute("set", set);
			request.getRequestDispatcher("/set/edit-set.jsp").forward(request, response);

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
		response.setCharacterEncoding("UTF-8");

		try {

			String setIdReq = (String) request.getParameter("setid");
			Integer setId = Integer.parseInt(setIdReq);
			// get set properties from database
			Myset set = Config.daoSet.selectById(setId);
			// update properties
			String setNameReq = (String) request.getParameter("setname");
			set.setName(setNameReq);
			String setDescriptionReq = (String) request.getParameter("setdescription");
			set.setDescription(setDescriptionReq);
			// store update set in database
			Config.daoSet.update(set);
			request.setAttribute("message", "El set ha sido actualizado.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		} catch (NumberFormatException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (JdbcException e) {
			e.printStackTrace();
			// throw new RuntimeException(e);
			request.setAttribute("error", "El set no ha podido ser actualizado.");
			request.getRequestDispatcher("/message.jsp").forward(request, response);

		}

	}

}
