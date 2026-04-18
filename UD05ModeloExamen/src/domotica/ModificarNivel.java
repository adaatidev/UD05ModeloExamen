package domotica;

public interface ModificarNivel {

	/**
	 * Método para subir el nivel de altavoz y luz, si el dispositivo está apagado
	 * lanza la excepción
	 * 
	 * @throws DispositivoApagadoException
	 */
	void subirNivel() throws DispositivoApagadoException;

	/**
	 * Método para bajar el nivel de altavoz y luz, si el dispositivo está apagado
	 * lanza la excepción
	 * 
	 * @throws DispositivoApagadoException
	 */
	void bajarNivel() throws DispositivoApagadoException;
}
