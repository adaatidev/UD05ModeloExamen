package domotica;

/**
 * Subclase Luz que hereda de Dispositivo e implementa la interfaz
 * ModificarNivel
 */
public class Luz extends Dispositivo implements ModificarNivel {

	// Variables propias de la subclase + constante para subir y bajar el nivel
	final int UDS = 10;
	private String color;
	private int brillo = 50;

	// Constructor con parámetros
	public Luz(String nombre, String marca, double precio, String colorInicial) {
		super(nombre, marca, precio);
		this.color = colorInicial;
	}

	// Getters y setters necesarios
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Método heredado de la interfaz ModificarNivel, sube el nivel (+10) si está
	 * encendido, si no, lanza una excepción
	 */
	@Override
	public void subirNivel() throws DispositivoApagadoException {
		if (!isEncendido()) {
			throw new DispositivoApagadoException();
		}
		this.brillo = Math.min(100, brillo + UDS);
	}

	/**
	 * Método heredado de la interfaz ModificarNivel, baja el nivel (-10) si está
	 * encendido, si no, lanza una excepción
	 */
	@Override
	public void bajarNivel() throws DispositivoApagadoException {
		if (!isEncendido()) {
			throw new DispositivoApagadoException();
		}
		this.brillo = Math.max(0, brillo - UDS);
	}

	/**
	 * Método toString que imprime lo mismo que en Dispositivo + información
	 * adicional de la propia clase
	 */
	@Override
	public String toString() {
		return super.toString() + " | Color: " + color + " | Brillo: " + brillo;
	}
}
