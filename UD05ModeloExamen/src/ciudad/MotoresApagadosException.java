package ciudad;

/** Excepción lanzada al intentar operar un dron inactivo */
public class MotoresApagadosException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Error: El dron tiene los motores apagados y no puede maniobrar.";
	}
}
