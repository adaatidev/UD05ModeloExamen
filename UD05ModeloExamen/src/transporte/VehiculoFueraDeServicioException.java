package transporte;

/**
 * Excepción personalizada para errores de estado en los vehículos.
 */
public class VehiculoFueraDeServicioException extends Exception {
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Error: El vehículo no está operativo";
	}

}
