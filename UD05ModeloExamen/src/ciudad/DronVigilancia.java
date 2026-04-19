package ciudad;

public class DronVigilancia extends Dron implements Camara {
	private String[] filtros = { "RGB", "NOCTURNA", "TÉRMICA" };
	private int filtroActual = 0;
	private boolean grabando = false;
	private String resolucion = "";

	public DronVigilancia(String matricula, String marca, double precio) {
		super(matricula, marca, precio);
	}

	public void rotarFiltro() {
		// TRAMPA 6: El ciclo infinito con módulo (%)
		this.filtroActual = (filtroActual + 1) % filtros.length;
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
		return String.format("[Vigilancia] Filtro: %s | Grabando: %b (%s)", filtros[filtroActual], grabando,
				grabando ? resolucion : "OFF");
	}
}
