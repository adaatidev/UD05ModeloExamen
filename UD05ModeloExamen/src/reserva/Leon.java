package reserva;

public class Leon extends Animal implements Entrenable {
	private double tamañoMelena;
	private int obediencia = 10;

	public Leon(String id, int edad, double tamañoMelena) {
		super(id, "León", edad);
		this.tamañoMelena = tamañoMelena;
	}

	@Override
	public void realizarTruco() throws AccionNoPermitidaException {
		if (!isEnLibertad())
			throw new AccionNoPermitidaException();
		this.obediencia = Math.min(100, obediencia + 5);
	}

	@Override
	public int obtenerNivelObediencia() {
		return obediencia;
	}

	@Override
	public String toString() {
		return String.format("[León] ID: %s | Edad: %d | Melena: %.1f | Obediencia: %d%% | Libertad: %b",
				getClass().getSimpleName(), getEdad(), tamañoMelena, obediencia, isEnLibertad());
	}
}
