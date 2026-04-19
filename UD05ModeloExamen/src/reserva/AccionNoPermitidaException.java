package reserva;

/**
 * Excepción lanzada al intentar realizar acciones con animales que no están
 * libres.
 */
public class AccionNoPermitidaException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Error: El animal no está en libertad.";
	}
}
