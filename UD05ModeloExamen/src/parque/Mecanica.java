package parque;

/** Capacidad de modificar la velocidad de la atracción */
public interface Mecanica {
	void acelerar() throws AtraccionDetenidaException;

	void frenar() throws AtraccionDetenidaException;
}
