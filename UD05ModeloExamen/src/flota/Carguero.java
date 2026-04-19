package flota;

public class Carguero extends Nave implements Navegable {
	private double capacidadCarga;
	private int velocidad = 0;

	public Carguero(String matricula, String faccion, double tonelaje, double capacidad) {
		super(matricula, faccion, tonelaje);
		this.capacidadCarga = capacidad;
	}

	@Override
	public void acelerar() throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.velocidad = Math.min(50, velocidad + 10); // Límite 50 (más lentos)
	}

	@Override
	public void frenar() throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.velocidad = Math.max(0, velocidad - 10);
	}

	@Override
	public String toString() {
		return String.format("[Carguero] Carga: %.1ft | Vel: %d | Motores: %b", capacidadCarga, velocidad,
				isMotoresEncendidos());
	}
}
