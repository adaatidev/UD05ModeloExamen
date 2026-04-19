package juego;

/**
 * Excepción lanzada al intentar realizar acciones ofensivas/defensivas fuera de
 * combate
 */
public class EstadoPacificoException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Error: El personaje no está en combate y no puede actuar.";
	}
}
