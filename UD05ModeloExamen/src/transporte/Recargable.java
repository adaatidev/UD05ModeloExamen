package transporte;

/** Capacidad de recargar energía eléctrica */
public interface Recargable {

	void cargarBateria() throws VehiculoFueraDeServicioException;

	int consultarNivel();

}
