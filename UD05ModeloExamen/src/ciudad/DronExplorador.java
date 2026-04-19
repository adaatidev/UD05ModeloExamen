package ciudad;

public class DronExplorador extends Dron implements Vuelo {
	private int altitud = 0;

	public DronExplorador(String matricula, String marca, double precio) {
		super(matricula, marca, precio);
	}

	@Override
	public void subirAltitud() throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.altitud = Math.min(500, altitud + 50); // TRAMPA 4: Math.min para el techo
	}

	@Override
	public void bajarAltitud() throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.altitud = Math.max(0, altitud - 50); // TRAMPA 5: Math.max para el suelo
	}

	@Override
	public String toString() {
		return String.format("[Explorador] Altitud: %dm | Motores: %b", altitud, isMotoresEncendidos());
	}
}
