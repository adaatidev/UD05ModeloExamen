package parque;

/** Capacidad de ejecutar un show con actores o animatrónica */
public interface Tematica {
	void iniciarEspectaculo(String tematica) throws AtraccionDetenidaException;

	void detenerEspectaculo() throws AtraccionDetenidaException;

	boolean isEspectaculoActivo();
}
