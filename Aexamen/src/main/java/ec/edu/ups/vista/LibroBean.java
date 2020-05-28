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
	private Autor autor;
	private List<Libro>libros;
	private int id;
	private Capitulo capitulo;

	
	@PostConstruct
	public void init() {
		libro= new Libro();
		libro.addCapitulos(new Capitulo());	
		id=0;
		capitulo = new Capitulo();
		autor=new Autor();
		
	}	
	
	public Capitulo getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		System.out.println("--------"+libro.toString());
		System.out.println("--------"+capitulo.toString());
		System.out.println("--------"+autor.toString());
		try {
			capitulo = new Capitulo();
			cON.guardar(libro);
			System.out.println("--------"+libro.toString());
			System.out.println("--------"+capitulo.toString());
			System.out.println("--------"+autor.toString());
			//init();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listar";
	}

	
	public  String buscar() throws Exception {
		
		 autor=cON.buscar(autor.getCodigo());
	   
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
		
		capitulo.setAutor(autor);
		libro.addCapitulos(new Capitulo());
		System.out.println(autor.toString());
		System.out.println(capitulo.toString());
		System.out.println(libro.toString());
		
	}

}
