package flota;

/** Define el comportamiento de naves con capacidad de maniobra avanzada */
public interface Navegable {
	void acelerar() throws MotoresApagadosException;

	void frenar() throws MotoresApagadosException;
}
