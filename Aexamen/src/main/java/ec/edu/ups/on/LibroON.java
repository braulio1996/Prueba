package ec.edu.ups.on;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.dao.LibroDAO;
import ec.edu.ups.modelo.Autor;
import ec.edu.ups.modelo.Libro;


@Stateless
public class LibroON {
	
	@Inject
	private LibroDAO pdao;
	
	
	
	
	public void guardar(Libro libro) throws Exception {
		pdao.insertar(libro);
		
	}


	

	public List<Libro>listar() throws Exception{
		return pdao.listar();
	
}

	
	public Autor buscar(int isbnn) throws Exception {
		return pdao.buscar(isbnn);
	}

}
