package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonEAO {
	@PersistenceContext(name = "PersonPU")
	private EntityManager em;
	
	public PersonEAO() {
		
	}
	@SuppressWarnings("unchecked")
	public List<Person> hentPaameldingsListe() {
		return em.createQuery("SELECT p FROM Person p").getResultList();
	}
	public void leggTil (Person p) {
		em.persist(p);
	}
}
