package biblioteca;

public interface Consultable {
	void abrirConsulta() throws RecursoNoDisponibleException;

	void cerrarConsulta();
}
