package flota;

/** Define el comportamiento de naves con sistemas de defensa activa */
public interface Defendible {
	void activarEscudos(String nivel) throws MotoresApagadosException;

	void desactivarEscudos() throws MotoresApagadosException;

	boolean isEscudosActivos();
}
