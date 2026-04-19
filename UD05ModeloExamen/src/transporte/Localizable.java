package transporte;

/** Capacidad de rastreo mediante coordenadas */
public interface Localizable {

	void actualizarCoordenadas(double x, double y) throws VehiculoFueraDeServicioException;

	String obtenerUbicacion();

}
