package reserva;

public class Elefante extends Animal implements Entrenable {
	private double pesoColmillos;
	private String[] modos = { "PASIVO", "ALERTA", "SOCIAL" };
	private int modoActual = 0;
	private int obediencia = 20;

	public Elefante(String id, int edad, double pesoColmillos) {
		super(id, "Elefante", edad);
		this.pesoColmillos = pesoColmillos;
	}

	public void cambiarModo() {
		modoActual = (modoActual + 1) % modos.length;
	}

	@Override
	public void realizarTruco() throws AccionNoPermitidaException {
		if (!isEnLibertad())
			throw new AccionNoPermitidaException();
		this.obediencia = Math.min(100, obediencia + 2);
	}

	@Override
	public int obtenerNivelObediencia() {
		return obediencia;
	}

	@Override
	public String toString() {
		return "[Elefante] Modo: " + modos[modoActual] + " | Obediencia: " + obediencia + "%";
	}
}
