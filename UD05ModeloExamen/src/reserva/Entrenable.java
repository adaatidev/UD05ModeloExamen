package reserva;

/** Capacidad de ser entrenado */
public interface Entrenable {
	void realizarTruco() throws AccionNoPermitidaException;

	int obtenerNivelObediencia();
}