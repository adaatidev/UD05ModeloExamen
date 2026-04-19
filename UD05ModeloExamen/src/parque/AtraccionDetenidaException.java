package parque;

/**
 * Excepción lanzada al intentar interactuar con la maquinaria de una atracción
 * detenida.
 */
public class AtraccionDetenidaException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Error: La atracción está detenida por protocolo de seguridad.";
	}
}
