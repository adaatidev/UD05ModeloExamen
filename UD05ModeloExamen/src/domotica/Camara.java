package domotica;

/**
 * Subclase Camara que hereda de Dispositivo e implementa la interfaz
 * EmitirAlerta
 */
public class Camara extends Dispositivo implements EmitirAlerta {

	// Variables propias de la subclase
	private String resolucion;
	private boolean grabando = false;
	private boolean alertaActiva = false;
	private String mensajeAlerta = "";

	// Constructor con parámetros
	public Camara(String nombre, String marca, double precio, String res) {
		super(nombre, marca, precio);
		this.resolucion = res;
	}

	/**
	 * Método que inicia la grabación si está encendido, si no, lanza una excepción
	 * 
	 * @throws DispositivoApagadoException
	 */
	public void iniciarGrabacion() throws DispositivoApagadoException {
		if (!isEncendido()) {
			throw new DispositivoApagadoException();
		}
		this.grabando = true;
	}

	/**
	 * Método para detener la grabación cambiando el boolean
	 */
	public void detenerGrabacion() {
		this.grabando = false;
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
		return super.toString() + " | Res: " + resolucion + " | Grabando: " + grabando + " | Alerta: "
				+ (alertaActiva ? mensajeAlerta : "No");
	}
}
