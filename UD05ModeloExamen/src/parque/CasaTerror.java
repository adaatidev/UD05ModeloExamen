package parque;

public class CasaTerror extends Atraccion implements Tematica {
	private int nivelMiedo;
	private boolean espectaculoActivo = false;
	private String tematicaActual = "";

	public CasaTerror(String id, String nombre, double precio, int nivelMiedo) {
		super(id, nombre, precio);
		this.nivelMiedo = nivelMiedo;
	}

	@Override
	public void iniciarEspectaculo(String tematica) throws AtraccionDetenidaException {
		if (!isEnMarcha())
			throw new AtraccionDetenidaException();
		this.espectaculoActivo = true;
		this.tematicaActual = tematica;
	}

	@Override
	public void detenerEspectaculo() throws AtraccionDetenidaException {
		if (!isEnMarcha())
			throw new AtraccionDetenidaException();
		this.espectaculoActivo = false;
	}

	@Override
	public boolean isEspectaculoActivo() {
		return espectaculoActivo;
	}

	@Override
	public String toString() {
		return String.format("[Casa Terror] Nivel: %d | Show: %b (%s)", nivelMiedo, espectaculoActivo,
				espectaculoActivo ? tematicaActual : "Cerrado");
	}
}
