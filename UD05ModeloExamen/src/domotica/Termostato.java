package domotica;

/**
 * Subclase Termostato que hereda de Dispositivo e implementa la interfaz
 * EmitirAlerta
 */
public class Termostato extends Dispositivo implements EmitirAlerta {

	// Variables propias de la subclase
	private double tempObjetivo = 21.0;
	private String[] modos = { "CALEFACCIÓN", "REFRIGERACIÓN", "ECO" };
	private int modoActual = 0;
	private boolean alertaActiva = false;
	private String mensajeAlerta = "";

	// Constructor con parámetros
	public Termostato(String nombre, String marca, double precio) {
		super(nombre, marca, precio);
	}

	/**
	 * Método para cambiar el modo, el modo se suma uno así que pasa al siguiente
	 * modo y se divide entre la longitud del array (3) para que siempre vuelva a
	 * ser 0
	 */
	public void cambiarModo() {
		modoActual = (modoActual + 1) % modos.length;
	}

	/**
	 * Método heredado de la interfaz EmitirAlerta que activa la alerta si el
	 * dispositivo está encendido, si no, lanza una excepción
	 */
	@Override
	public void activarAlerta(String mensaje) throws DispositivoApagadoException {
		if (!isEncendido()) {
			throw new DispositivoApagadoException();
		}
		this.alertaActiva = true;
		this.mensajeAlerta = mensaje;
	}

	/**
	 * Método heredado de la interfaz EmitirAlerta que desactiva la alerta si el
	 * dispositivo está encendido, si no, lanza una excepción
	 */
	@Override
	public void desactivarAlerta() throws DispositivoApagadoException {
		if (!isEncendido()) {
			throw new DispositivoApagadoException();
		}
		this.alertaActiva = false;
	}

	/**
	 * Método que devuelve si la alerta está activa o no
	 */
	@Override
	public boolean isAlertaActiva() {
		return alertaActiva;
	}

	/**
	 * Método toString que imprime lo mismo que en Dispositivo + información
	 * adicional de la propia clase
	 */
	@Override
	public String toString() {
		return super.toString() + " | Modo: " + modos[modoActual] + " | Alerta: "
				+ (alertaActiva ? mensajeAlerta : "Ninguna");
	}
}
