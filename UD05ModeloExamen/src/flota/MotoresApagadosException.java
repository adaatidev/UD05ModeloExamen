package flota;

/**
 * Excepción lanzada al intentar realizar maniobras o activar sistemas cuando
 * los motores de la nave están apagados.
 */
public class MotoresApagadosException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Error: Los motores de la nave están apagados.";
	}
}
