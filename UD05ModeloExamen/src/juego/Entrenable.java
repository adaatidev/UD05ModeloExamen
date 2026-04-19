package juego;

/**
 * Comportamiento para personajes físicos que modifican sus atributos en batalla
 */
public interface Entrenable {
	void subirAtributo() throws EstadoPacificoException;

	void bajarAtributo() throws EstadoPacificoException;
}
