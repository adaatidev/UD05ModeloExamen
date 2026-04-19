package juego;

public class Arquero extends Personaje implements Entrenable {
	private String tipoArco;
	private int precision = 50;

	public Arquero(String nombre, String raza, double puntosSalud, String tipoArco) {
		super(nombre, raza, puntosSalud);
		this.tipoArco = tipoArco;
	}

	@Override
	public void subirAtributo() throws EstadoPacificoException {
		if (!isEnCombate())
			throw new EstadoPacificoException();
		this.precision = Math.min(100, precision + 15);
	}

	@Override
	public void bajarAtributo() throws EstadoPacificoException {
		if (!isEnCombate())
			throw new EstadoPacificoException();
		this.precision = Math.max(0, precision - 15);
	}

	@Override
	public String toString() {
		return String.format("[Arquero] Arco: %s | Precisión: %d | Combate: %b", tipoArco, precision, isEnCombate());
	}
}
