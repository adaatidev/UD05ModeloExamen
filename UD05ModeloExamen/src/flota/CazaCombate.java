package flota;

public class CazaCombate extends Nave implements Navegable {
	private String arma;
	private int velocidad = 0;

	public CazaCombate(String matricula, String faccion, double tonelaje, String arma) {
		super(matricula, faccion, tonelaje);
		this.arma = arma;
	}

	@Override
	public void acelerar() throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.velocidad = Math.min(200, velocidad + 50); // Límite 200
	}

	@Override
	public void frenar() throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.velocidad = Math.max(0, velocidad - 50); // Límite 0
	}

	@Override
	public String toString() {
		return String.format("[Caza] Arma: %s | Vel: %d | Motores: %b", arma, velocidad, isMotoresEncendidos());
	}
}
