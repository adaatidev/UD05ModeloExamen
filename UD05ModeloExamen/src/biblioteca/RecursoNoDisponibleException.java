package biblioteca;

/**
 * Excepción lanzada cuando un recurso no puede ser procesado por estar
 * prestado.
 */
public class RecursoNoDisponibleException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Error: El recurso ya está prestado o no se puede acceder.";
	}
}
