package biblioteca;

public class Ebook extends Recurso implements Descargable {
	private String formato;
	private int descargasTotal = 0;

	public Ebook(String isbn, String titulo, String autor, double precio, String formato) {
		super(isbn, titulo, autor, precio);
		this.formato = formato;
	}

	@Override
	public void descargar() throws RecursoNoDisponibleException {
		if (isPrestado())
			throw new RecursoNoDisponibleException();
		this.descargasTotal++;
	}

	@Override
	public int getTamañoMB() {
		return 15;
	} // Ejemplo fijo

	@Override
	public String toString() {
		return String.format("[Ebook] %s (%s) - Descargas: %d | Prestado: %b", getTitulo(), formato, descargasTotal,
				isPrestado());
	}
}
