package ciudad;

/**
 * Define el comportamiento de los drones con capacidad de cambiar su cota de
 * vuelo
 */
public interface Vuelo {
	void subirAltitud() throws MotoresApagadosException;

	void bajarAltitud() throws MotoresApagadosException;
}
