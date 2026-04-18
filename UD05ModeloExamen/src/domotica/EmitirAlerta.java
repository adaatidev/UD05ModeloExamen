package domotica;

public interface EmitirAlerta {

	/**
	 * Método para activar e imprimir por consola un mensaje, si el dispositivo está
	 * apagado lanza una excepción
	 * 
	 * @param mensaje
	 * @throws DispositivoApagadoException
	 */
	void activarAlerta(String mensaje) throws DispositivoApagadoException;

	/**
	 * Método para desactivar una alerta, si el dispositivo está apagado lanza una
	 * excepción
	 * 
	 * @param mensaje
	 * @throws DispositivoApagadoException
	 */
	void desactivarAlerta() throws DispositivoApagadoException;

	/**
	 * Comprueba si la alerta está activa para poder desactivarla
	 * 
	 * @return
	 */
	boolean isAlertaActiva();

}
