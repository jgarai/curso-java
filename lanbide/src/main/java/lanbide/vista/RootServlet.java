package lanbide.vista;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanbide.modelo.Cliente;

@WebServlet("/")
public class RootServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lanbide");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		List<Cliente> clientes = entityManager.createQuery("from Cliente", Cliente.class).getResultList();

		request.setAttribute("clientes", clientes);
		entityManager.getTransaction().commit();
		entityManager.close();

		request.getRequestDispatcher("/WEB-INF/root.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
