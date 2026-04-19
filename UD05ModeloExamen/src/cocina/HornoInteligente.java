package cocina;

public class HornoInteligente extends Electrodomestico implements Programable {
	private String[] modosCalor = { "GRILL", "VENTILADOR", "BÓVEDA Y SOLERA" };
	private int modoActual = 0;
	private boolean enPrograma = false;
	private String receta = "";

	public HornoInteligente(String numSerie, String marca, double precio) {
		super(numSerie, marca, precio);
	}

	public void rotarModoCalor() {
		this.modoActual = (modoActual + 1) % modosCalor.length; // Lógica cíclica garantizada
	}

	@Override
	public void iniciarPrograma(String nombre) throws ElectrodomesticoApagadoException {
		if (!isEncendido())
			throw new ElectrodomesticoApagadoException();
		this.enPrograma = true;
		this.receta = nombre;
	}

	@Override
	public void detenerPrograma() throws ElectrodomesticoApagadoException {
		if (!isEncendido())
			throw new ElectrodomesticoApagadoException();
		this.enPrograma = false;
	}

	@Override
	public boolean isProgramado() {
		return enPrograma;
	}

	@Override
	public String toString() {
		return "[Horno] Modo: " + modosCalor[modoActual] + " | Horneando: " + (enPrograma ? receta : "Nada");
	}
}
