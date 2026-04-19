package cocina;

/** Excepción lanzada cuando se interactúa con un dispositivo apagado */
public class ElectrodomesticoApagadoException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Error: El electrodoméstico está apagado y no responde.";
	}
}
