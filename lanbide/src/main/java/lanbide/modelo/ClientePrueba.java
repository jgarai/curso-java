package lanbide.modelo;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientePrueba {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lanbide");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		// insertar entidades
		Cliente c = new Cliente(null, "tomás", "rodriguez", "600 567 809", "tomasrodriguez@gmail.com",
				new BigDecimal("1000"));

		entityManager.persist(c);

		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
