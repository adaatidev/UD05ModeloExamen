package transporte;

public class AutobusElectrico extends Vehiculo implements Recargable {

	final int UDS = 20;
	private int linea;
	private int capacidad;

	public AutobusElectrico(String id, String marca, double autonomia, int numLinea) {
		super(id, marca, autonomia);
		this.linea = numLinea;
		this.capacidad = 50;
	}

	@Override
	public void cargarBateria() throws VehiculoFueraDeServicioException {
		if (!isEnServicio()) {
			throw new VehiculoFueraDeServicioException();
		}
		// Aumenta 20km, máximo 400km
		setAutonomia(Math.min(400, getAutonomia() + UDS));
	}

	@Override
	public int consultarNivel() {
		return (int) ((getAutonomia() / 400) * 100);
	}

	@Override
	public String toString() {
		return String.format("[Autobús L-%d] Autonomía: %.1fkm | Operativo: %b", linea, getAutonomia(), isEnServicio());
	}
}
