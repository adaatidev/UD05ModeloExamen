package reserva;

/** Capacidad de rastreo GPS */
public interface Localizable {
	void registrarCoordenadas(double x, double y) throws AccionNoPermitidaException;

	String obtenerCoordenadas();
}
