package juego;

public class Clerigo extends Personaje implements Hechizable {
	private String deidad;
	private boolean auraActiva = false;
	private String tipoAura = "";

	public Clerigo(String nombre, String raza, double puntosSalud, String deidad) {
		super(nombre, raza, puntosSalud);
		this.deidad = deidad;
	}

	@Override
	public void activarAura(String tipo) throws EstadoPacificoException {
		if (!isEnCombate())
			throw new EstadoPacificoException();
		this.auraActiva = true;
		this.tipoAura = tipo;
	}

	@Override
	public void desactivarAura() throws EstadoPacificoException {
		if (!isEnCombate())
			throw new EstadoPacificoException();
		this.auraActiva = false;
	}

	@Override
	public boolean isAuraActiva() {
		return auraActiva;
	}

	@Override
	public String toString() {
		return String.format("[Clérigo] Deidad: %s | Aura: %b (%s)", deidad, auraActiva,
				auraActiva ? tipoAura : "Ninguna");
	}
}
