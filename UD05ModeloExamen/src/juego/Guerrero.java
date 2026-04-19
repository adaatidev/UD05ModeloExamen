package juego;

public class Guerrero extends Personaje implements Entrenable {
	private int furia = 0;

	public Guerrero(String nombre, String raza, double puntosSalud) {
		super(nombre, raza, puntosSalud);
	}

	@Override
	public void subirAtributo() throws EstadoPacificoException {
		if (!isEnCombate())
			throw new EstadoPacificoException();
		this.furia = Math.min(100, furia + 20); // Límite superior
	}

	@Override
	public void bajarAtributo() throws EstadoPacificoException {
		if (!isEnCombate())
			throw new EstadoPacificoException();
		this.furia = Math.max(0, furia - 20); // Límite inferior
	}

	@Override
	public String toString() {
		return String.format("[Guerrero] Furia: %d | Combate: %b", furia, isEnCombate());
	}
}
