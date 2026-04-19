package cocina;

/** Capacidad para ejecutar programas o recetas automáticas */
public interface Programable {
	void iniciarPrograma(String nombre) throws ElectrodomesticoApagadoException;

	void detenerPrograma() throws ElectrodomesticoApagadoException;

	boolean isProgramado();
}
