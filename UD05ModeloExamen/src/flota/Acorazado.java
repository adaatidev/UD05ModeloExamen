package flota;

public class Acorazado extends Nave implements Defendible {
	private int numCanones;
	private boolean escudosActivos = false;
	private String nivelEscudo = "";

	public Acorazado(String matricula, String faccion, double tonelaje, int numCanones) {
		super(matricula, faccion, tonelaje);
		this.numCanones = numCanones;
	}

	@Override
	public void activarEscudos(String nivel) throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.escudosActivos = true;
		this.nivelEscudo = nivel;
	}

	@Override
	public void desactivarEscudos() throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.escudosActivos = false;
	}

	@Override
	public boolean isEscudosActivos() {
		return escudosActivos;
	}

	@Override
	public String toString() {
		return String.format("[Acorazado] Cañones: %d | Escudos: %b (%s)", numCanones, escudosActivos,
				escudosActivos ? nivelEscudo : "OFF");
	}
}
