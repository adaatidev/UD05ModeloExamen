package transporte;

public class Patinete extends Vehiculo implements Recargable {
	private int nivelBateria;

	public Patinete(String id, String marca, double autonomia) {
		super(id, marca, autonomia);
		this.nivelBateria = (int) (autonomia * 2);
	}

	@Override
	public void cargarBateria() throws VehiculoFueraDeServicioException {
		if (!isEnServicio())
			throw new VehiculoFueraDeServicioException();
		this.nivelBateria = Math.min(100, nivelBateria + 10);
		setAutonomia(nivelBateria / 2.0);
	}

	@Override
	public int consultarNivel() {
		return nivelBateria;
	}

	@Override
	public String toString() {
		return "[Patinete] Batería: " + nivelBateria + "% | Autonomía: " + getAutonomia() + "km";
	}
}
