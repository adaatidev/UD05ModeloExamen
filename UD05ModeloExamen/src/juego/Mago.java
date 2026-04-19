package juego;

public class Mago extends Personaje implements Hechizable {
	private String[] elementos = { "FUEGO", "HIELO", "RAYO", "TIERRA" };
	private int elementoActual = 0;
	private boolean auraActiva = false;
	private String tipoAura = "";

	public Mago(String nombre, String raza, double puntosSalud) {
		super(nombre, raza, puntosSalud);
	}

	public void rotarElemento() {
		this.elementoActual = (elementoActual + 1) % elementos.length; // Lógica cíclica
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
		return String.format("[Mago] Elemento: %s | Aura: %b (%s)", elementos[elementoActual], auraActiva,
				auraActiva ? tipoAura : "Ninguna");
	}
}
