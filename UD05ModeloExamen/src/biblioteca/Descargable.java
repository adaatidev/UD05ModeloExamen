package biblioteca;

public interface Descargable {
	void descargar() throws RecursoNoDisponibleException;

	int getTamañoMB();
}
