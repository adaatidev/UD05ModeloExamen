package ciudad;

public class DronAgricola extends Dron implements Camara {
	private String tipoFertilizante;
	private boolean grabando = false;
	private String resolucion = "";

	public DronAgricola(String matricula, String marca, double precio, String fertilizante) {
		super(matricula, marca, precio);
		this.tipoFertilizante = fertilizante;
	}

	@Override
	public void iniciarGrabacion(String res) throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.grabando = true;
		this.resolucion = res;
	}

	@Override
	public void detenerGrabacion() throws MotoresApagadosException {
		if (!isMotoresEncendidos())
			throw new MotoresApagadosException();
		this.grabando = false;
	}

	@Override
	public boolean isGrabando() {
		return grabando;
	}

	@Override
	public String toString() {
		return String.format("[Agrícola] Fertilizante: %s | Grabando: %b (%s)", tipoFertilizante, grabando,
				grabando ? resolucion : "OFF");
	}
}
