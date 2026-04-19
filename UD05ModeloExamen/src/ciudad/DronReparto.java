package ciudad;

public class DronReparto extends Dron implements Vuelo {
	private double cargaMax;
	private int altitud = 0;

	public DronReparto(String matricula, String marca, double precio, double cargaMax) {
		super(matricula, marca, precio);
		this.cargaMax = cargaMax;
	}

	@Override
	public void subirAltitud() throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.altitud = Math.min(120, altitud + 10);
	}

	@Override
	public void bajarAltitud() throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.altitud = Math.max(0, altitud - 10);
	}

	@Override
	public String toString() {
		return String.format("[Reparto] Carga: %.1fkg | Altitud: %dm | Motores: %b", cargaMax, altitud,
				isMotoresEncendidos());
	}
}
