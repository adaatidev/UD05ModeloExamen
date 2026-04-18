package domotica;

/**
 * Subclase Altavoz que hereda de Dispositivo e implementa la interfaz
 * ModificarNivel
 */
public class Altavoz extends Dispositivo implements ModificarNivel {

	// Variables propias de la subclase + constante para subir y bajar el nivel
	private final int UDS = 5;
	private String asistente;
	private int volumen = 30;

	// Constructor con parámetros
	public Altavoz(String nombre, String marca, double precio, String asistente) {
		super(nombre, marca, precio);
		this.asistente = asistente;
	}

	// Getters y setters necesarios
	public String getAsistente() {
		return asistente;
	}

	/**
	 * Método heredado de la interfaz ModificarNivel, sube el nivel (+5) si está
	 * encendido, si no, lanza una excepción
	 */
	@Override
	public void subirNivel() throws DispositivoApagadoException {
		if (!isEncendido()) {
			throw new DispositivoApagadoException();
		}
		this.volumen = Math.min(100, volumen + UDS);
	}

	/**
	 * Método heredado de la interfaz ModificarNivel, baja el nivel (-5) si está
	 * encendido, si no, lanza una excepción
	 */
	@Override
	public void bajarNivel() throws DispositivoApagadoException {
		if (!isEncendido()) {
			throw new DispositivoApagadoException();
		}
		this.volumen = Math.max(0, volumen - UDS);
	}

	/**
	 * Método toString que imprime lo mismo que en Dispositivo + información
	 * adicional de la propia clase
	 */
	@Override
	public String toString() {
		return super.toString() + " | Asistente: " + asistente + " | Volumen: " + volumen;
	}

}
