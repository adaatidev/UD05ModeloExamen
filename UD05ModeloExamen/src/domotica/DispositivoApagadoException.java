package domotica;

/**
 * Clase para emitir una excepción si un dispositivo está apagado
 */
public class DispositivoApagadoException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Error: el dispositivo está apagado.";
	}

}
