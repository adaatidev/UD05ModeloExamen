package videojuego;

public class Mago extends Personaje implements LanzadorMagia {
	private int mana = 50;

	public Mago(String nombre, String raza, int nivel) {
		super(nombre, raza, nivel);
	}

	@Override
	public void lanzarHechizo() throws PersonajeMuertoException {
		if (!isVivo())
			throw new PersonajeMuertoException();
		if (mana >= 10) {
			this.mana -= 10;
			System.out.println(getNombre() + " lanza una bola de fuego.");
		} else {
			System.out.println(getNombre() + " no tiene maná suficiente.");
		}
	}

	@Override
	public void recuperarMana() {
		this.mana = Math.min(100, mana + 20); // Límite máximo 100
	}

	@Override
	public String toString() {
		return String.format("[Mago] %s | Maná: %d | Vivo: %b", getNombre(), mana, isVivo());
	}
}
