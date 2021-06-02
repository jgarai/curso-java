package lanbide.vista;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanbide.modelo.Cliente;

@WebServlet("/editarcliente")
public class EditarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String clienteIdReq = request.getParameter("clienteid");
			Long clienteId = Long.parseLong(clienteIdReq);
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lanbide");

			EntityManager entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();

			Cliente cliente = entityManager.find(Cliente.class, clienteId);

			request.setAttribute("cliente", cliente);

			entityManager.getTransaction().commit();
			entityManager.close();
			request.getRequestDispatcher("/WEB-INF/editar-cliente.jsp").forward(request, response);

		} catch (NumberFormatException e) {

			e.printStackTrace();
			request.setAttribute("error", "Ha habido un error editando la ficha del cliente.");

			request.getRequestDispatcher("/WEB-INF/root.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String clienteIdReq = request.getParameter("clienteid");
			Long clienteId = Long.parseLong(clienteIdReq);

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lanbide");

			EntityManager entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();

			// Cliente cliente = entityManager.find(Cliente.class, clienteId);

			Cliente cliente = new Cliente();

			cliente.setId(clienteId);
			cliente.setNombre(request.getParameter("nombre"));
			cliente.setApellido(request.getParameter("apellido"));
			cliente.setTelefono(request.getParameter("telefono"));
			cliente.setEmail(request.getParameter("email"));
			cliente.setSaldo(new BigDecimal(request.getParameter("saldo")));

			entityManager.merge(cliente);
			entityManager.getTransaction().commit();
			entityManager.close();
			request.setAttribute("mensaje", "El cliente ha sido editado con éxito.");

			request.getRequestDispatcher("").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
