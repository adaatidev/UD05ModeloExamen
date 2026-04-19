package cocina;

public class Cafetera extends Electrodomestico implements Programable {
	private String tipoGrano;
	private boolean enPrograma = false;
	private String tipoCafe = "";

	public Cafetera(String numSerie, String marca, double precio, String tipoGrano) {
		super(numSerie, marca, precio);
		this.tipoGrano = tipoGrano;
	}

	@Override
	public void iniciarPrograma(String nombre) throws ElectrodomesticoApagadoException {
		if (!isEncendido())
			throw new ElectrodomesticoApagadoException();
		this.enPrograma = true;
		this.tipoCafe = nombre;
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
		return "[Cafetera] Grano: " + tipoGrano + " | Preparando: " + (enPrograma ? tipoCafe : "Lista");
	}
}
