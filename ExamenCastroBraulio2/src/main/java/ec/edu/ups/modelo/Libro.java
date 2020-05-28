package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int isbnn;
	private String titulo;
	private String anioEdicion;
	private String editorial;
	@OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Capitulo>capitulos;
	public int getIsbnn() {
		return isbnn;
	}
	public void setIsbnn(int isbnn) {
		this.isbnn = isbnn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAnioEdicion() {
		return anioEdicion;
	}
	public void setAnioEdicion(String anioEdicion) {
		this.anioEdicion = anioEdicion;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	
	public void addCapitulos(Capitulo capitulo){
		if(capitulos==null) {
			capitulos= new ArrayList<Capitulo>();	
		}
		capitulos.add(capitulo);
}
}