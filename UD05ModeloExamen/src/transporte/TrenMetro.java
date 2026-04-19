package transporte;

public class TrenMetro extends Vehiculo implements Localizable {
	private int vagones;
	private String ubicacion = "Cocheras";

	public TrenMetro(String id, String marca, double autonomia, int vagones) {
		super(id, marca, autonomia);
		this.vagones = vagones;
	}

	@Override
	public void actualizarCoordenadas(double x, double y) throws VehiculoFueraDeServicioException {
		if (!isEnServicio())
			throw new VehiculoFueraDeServicioException();
		this.ubicacion = "Lat: " + x + ", Lon: " + y;
	}

	@Override
	public String obtenerUbicacion() {
		return ubicacion;
	}

	@Override
	public String toString() {
		return "[Tren Metro] Vagones: " + vagones + " | Ubicación: " + ubicacion;
	}
}
