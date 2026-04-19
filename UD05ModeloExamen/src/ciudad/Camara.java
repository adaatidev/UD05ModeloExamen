package ciudad;

/** Define el comportamiento de los drones equipados con sistemas ópticos */
public interface Camara {
	void iniciarGrabacion(String resolucion) throws MotoresApagadosException;

	void detenerGrabacion() throws MotoresApagadosException;

	boolean isGrabando();
}
