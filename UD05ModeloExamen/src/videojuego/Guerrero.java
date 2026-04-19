package videojuego;

public class Guerrero extends Personaje implements AtacanteFisico {
	private int fuerzaExtra;

	public Guerrero(String nombre, String raza, int nivel, int fuerzaExtra) {
		super(nombre, raza, nivel);
		this.fuerzaExtra = fuerzaExtra;
	}

	@Override
	public void atacarCuerpoACuerpo() throws PersonajeMuertoException {
		if (!isVivo())
			throw new PersonajeMuertoException();
		System.out.println(getNombre() + " da un golpe de espada con fuerza " + fuerzaExtra);
	}

	@Override
	public String toString() {
		return String.format("[Guerrero] %s | Nivel: %d | Fuerza: %d | Vivo: %b", getNombre(), super.compareTo(this),
				fuerzaExtra, isVivo()); // Simplificado para mostrar concepto
	}
}
