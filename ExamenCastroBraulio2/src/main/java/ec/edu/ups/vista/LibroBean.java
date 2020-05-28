package ec.edu.ups.vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.modelo.Autor;
import ec.edu.ups.modelo.Capitulo;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.on.LibroON;


@ManagedBean
@ViewScoped
public class LibroBean {
	@Inject
	private LibroON cON;
	
	private Libro libro;
	private Autor autor=new Autor();
	private List<Libro>libros;
	
	@PostConstruct
	public void init() {
		libro= new Libro();
		libro.addCapitulos(new Capitulo());
		
		
		
	}	
	
	public Autor getAutor() {
		return autor;
	}

	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String crear() {
		try {
			cON.guardar(libro);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listar";
	}
	

	public String ediatarAjax(int codigo) {
		System.out.println("=============="+codigo);
		try {
			autor=cON.buscar(codigo);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Libro> listar(){
		
		try {	
			this.libros=cON.listar();
			return libros;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
		
	}
	
	public void addCapitulos() {
		libro.addCapitulos(new Capitulo());
		
	}

}
