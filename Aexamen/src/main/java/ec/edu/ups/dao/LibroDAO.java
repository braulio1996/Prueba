package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ec.edu.ups.modelo.Autor;
import ec.edu.ups.modelo.Capitulo;
import ec.edu.ups.modelo.Libro;



@Stateless
public class LibroDAO {
	
	@PersistenceContext(name="ContatoswebPersistenceUnit")
	private EntityManager em;
public void insertar(Libro libro) throws Exception {
		
        try {  
        	em.persist(libro);
        	
        } catch (Exception e) {
        	System.out.println(e.toString());
        	
        } 	
	}
	
public Autor buscar2(int codigo) throws Exception {
	
	try {
			String jpql = "SELECT a FROM Autor a WHERE a.codigo = :codigo";
			Query query = em.createQuery(jpql, Autor.class);
			query.setParameter("codigo", codigo);
			Autor autor = (Autor) query.getSingleResult();
			
			return autor;
	    
	}catch(Exception e) {
		System.out.println(e.getMessage());
		throw new Exception(e.toString());
		
	}

}

public List<Libro>listar() throws Exception {
	
	try {
		String jpql = "SELECT l FROM Libro l";
		Query query = em.createQuery(jpql, Libro.class);
		List<Libro> libroz = query.getResultList();   
		for(Libro libro:libroz) {
			List<Capitulo> capitulos=libro.getCapitulos();
			libro.setCapitulos(capitulos);
			capitulos=null;
		}
	    return libroz;
	}catch(Exception e) {
		throw new Exception(e.toString());
	}
	
}
public Autor buscar(int codigo) {
	return em.find(Autor.class, codigo);
}
}
