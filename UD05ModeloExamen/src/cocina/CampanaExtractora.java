package cocina;

public class CampanaExtractora extends Electrodomestico implements Ajustable {
	private int velocidad = 0;

	public CampanaExtractora(String numSerie, String marca, double precio) {
		super(numSerie, marca, precio);
	}

	@Override
	public void subirNivel() throws ElectrodomesticoApagadoException {
		if (!isEncendido())
			throw new ElectrodomesticoApagadoException();
		this.velocidad = Math.min(5, velocidad + 1);
	}

	@Override
	public void bajarNivel() throws ElectrodomesticoApagadoException {
		if (!isEncendido())
			throw new ElectrodomesticoApagadoException();
		this.velocidad = Math.max(0, velocidad - 1);
	}

	@Override
	public String toString() {
		return "[Campana] Velocidad: " + velocidad + " | Estado: " + (isEncendido() ? "ON" : "OFF");
	}
}
