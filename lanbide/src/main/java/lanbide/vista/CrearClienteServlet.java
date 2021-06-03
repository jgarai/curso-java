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

@WebServlet("/crearcliente")
public class CrearClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String clienteIdReq = request.getParameter("clienteid");

		// Si no se acompa�a con un id es una creaccion de nueva ficha de cliente
		if (clienteIdReq == null || clienteIdReq.length() == 0) {
			request.getRequestDispatcher("/WEB-INF/crear-cliente.jsp").forward(request, response);
			return;

		}
		/*
		 * En caso de que si haya un id de cliente es un update pedimos a jpa el objeto
		 * del cliente y lo env�amos a la jsp donde se muestra el formulario para meter
		 * los datos a actualizar.
		 */
		try {
			Long clienteId = Long.parseLong(clienteIdReq);
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lanbide");

			EntityManager entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();

			Cliente cliente = entityManager.find(Cliente.class, clienteId);

			request.setAttribute("cliente", cliente);

			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
			request.getRequestDispatcher("/WEB-INF/crear-cliente.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("error", "Ha habido un error tratando de crear la ficha del cliente.");
			request.getRequestDispatcher("/").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		try {
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("email");
			BigDecimal saldo = new BigDecimal(request.getParameter("saldo"));
	

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lanbide");

			EntityManager entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();

			// Si no hay clienteid es crear una ficha nueva de cliente
			String clienteIdReq = request.getParameter("clienteid");
			if (clienteIdReq == null || clienteIdReq.length() == 0) {
				Cliente cliente = new Cliente(null, nombre, apellido, telefono, email, saldo);

				entityManager.persist(cliente);
				request.setAttribute("mensaje", "La ficha del cliente ha sido creada con �xito.");

			}
			// si hay clienteid es actualizar un cliente
			else {

				Long clienteId = Long.parseLong(clienteIdReq);
				Cliente cliente = entityManager.find(Cliente.class, clienteId);

				cliente.setNombre(request.getParameter("nombre"));
				cliente.setApellido(request.getParameter("apellido"));
				cliente.setTelefono(request.getParameter("telefono"));
				cliente.setEmail(request.getParameter("email"));
				cliente.setSaldo(new BigDecimal(request.getParameter("saldo")));
				request.setAttribute("mensaje", "La ficha del cliente ha sido editada con �xito.");

			}

			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();

			request.getRequestDispatcher("/").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("error", "Ha habido un error tratando de crear la ficha del cliente.");

			request.getRequestDispatcher("/").forward(request, response);
		}

	}

}
