package videojuego;

public class Paladin extends Personaje implements AtacanteFisico, LanzadorMagia {
	private int armadura;
	private int mana = 50;

	public Paladin(String nombre, String raza, int nivel, int armadura) {
		super(nombre, raza, nivel);
		this.armadura = armadura;
	}

	@Override
	public void atacarCuerpoACuerpo() throws PersonajeMuertoException {
		if (!isVivo())
			throw new PersonajeMuertoException();
		System.out.println(getNombre() + " golpea con su maza blindada.");
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
		this.mana = Math.min(100, mana + 20);
	}

	@Override
	public String toString() {
		return String.format("[Paladin] %s | Maná: %d | Vivo: %b", getNombre(), mana, isVivo());
	}
}
