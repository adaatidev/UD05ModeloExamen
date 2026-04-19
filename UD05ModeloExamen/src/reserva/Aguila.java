package reserva;

public class Aguila extends Animal implements Localizable {
	private double envergadura;
	private String gps = "Sin señal";

	public Aguila(String id, int edad, double envergadura) {
		super(id, "Águila", edad);
		this.envergadura = envergadura;
	}

	@Override
	public void registrarCoordenadas(double x, double y) throws AccionNoPermitidaException {
		if (!isEnLibertad())
			throw new AccionNoPermitidaException();
		this.gps = x + " / " + y;
	}

	@Override
	public String obtenerCoordenadas() {
		return gps;
	}

	@Override
	public String toString() {
		return "[Águila] Envergadura: " + envergadura + "m | GPS: " + gps;
	}
}
