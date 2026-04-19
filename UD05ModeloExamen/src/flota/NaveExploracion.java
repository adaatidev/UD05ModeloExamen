package flota;

public class NaveExploracion extends Nave implements Defendible {
	private String[] modosRadar = { "CORTO ALCANCE", "LARGO ALCANCE", "BIO-ESCANER" };
	private int radarActual = 0;
	private boolean escudosActivos = false;
	private String nivelEscudo = "";

	public NaveExploracion(String matricula, String faccion, double tonelaje) {
		super(matricula, faccion, tonelaje);
	}

	public void rotarRadar() {
		this.radarActual = (radarActual + 1) % modosRadar.length; // Ciclo infinito
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
		return String.format("[Exploración] Radar: %s | Escudos: %b (%s)", modosRadar[radarActual], escudosActivos,
				escudosActivos ? nivelEscudo : "OFF");
	}
}
