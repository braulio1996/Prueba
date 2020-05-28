package ec.edu.ups.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Capitulo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	private String descripsion;
	@OneToOne
	private Autor autor;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripsion() {
		return descripsion;
	}
	public void setDescripsion(String descripsion) {
		this.descripsion = descripsion;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Capitulo [codigo=" + codigo + ", descripsion=" + descripsion + ", autor=" + autor + "]";
	}
	

}
