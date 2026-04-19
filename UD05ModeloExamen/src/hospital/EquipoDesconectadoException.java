package hospital;

/**
 * Excepción lanzada al operar un equipo que no está conectado al paciente o
 * red.
 */
public class EquipoDesconectadoException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Error: El equipo médico está apagado o desconectado.";
	}
}
