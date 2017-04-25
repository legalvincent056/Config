package dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Client;


public class Dao implements IDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpacdi-pu");
	
	@Override
	public long addClient(Client client) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(client);
		tx.commit();
		em.close();
		return client.getId();
	}

	@Override
	public Collection<Client> findAllClient() {
		EntityManager em = emf.createEntityManager();
	
		List<Client> lc = em.createQuery("SELECT c FROM Client c").getResultList();
		
		em.close();
			return lc;
	}

	@Override
	public void suppClient(Client client) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.remove(em.contains(client) ? client : em.merge(client));
		
		tx.commit();
		em.close();
		
		
	}
	
	
	

	
	

}
