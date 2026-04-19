package biblioteca;

/**
 * Clase base para todos los elementos de la biblioteca.
 */
public abstract class Recurso implements Comparable<Recurso> {
	private String isbn;
	private String titulo;
	private String autor;
	private double precioReposicion;
	private boolean prestado;

	public Recurso(String isbn, String titulo, String autor, double precio) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.precioReposicion = precio;
		this.prestado = false; // Siempre disponible al crear
	}

	public void prestar() {
		this.prestado = true;
	}

	public void devolver() {
		this.prestado = false;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public String getTitulo() {
		return titulo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Recurso))
			return false;
		Recurso otro = (Recurso) obj;
		return isbn.equals(otro.isbn) && titulo.equals(otro.titulo);
	}

	@Override
	public int compareTo(Recurso otro) {
		// Orden alfabético por título
		return this.titulo.compareToIgnoreCase(otro.titulo);
	}

	@Override
	public abstract String toString();
}
