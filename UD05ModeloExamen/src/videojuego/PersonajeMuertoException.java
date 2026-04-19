package videojuego;

/** Excepción lanzada cuando un personaje sin vida intenta actuar */
public class PersonajeMuertoException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Error: El personaje está muerto y no puede realizar esta acción.";
	}
}
