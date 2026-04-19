package juego;

/**
 * Clase base para todos los héroes del juego.
 */
public abstract class Personaje implements Comparable<Personaje> {
	private String nombre;
	private String raza;
	private double puntosSalud;
	private boolean enCombate;

	public Personaje(String nombre, String raza, double puntosSalud) {
		this.nombre = nombre;
		this.raza = raza;
		this.puntosSalud = puntosSalud;
		this.enCombate = false; // Comienza siempre fuera de combate
	}

	public void entrarEnCombate() {
		this.enCombate = true;
	}

	public void salirDeCombate() {
		this.enCombate = false;
	}

	public boolean isEnCombate() {
		return enCombate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Personaje))
			return false;
		Personaje otro = (Personaje) obj;
		return nombre.equals(otro.nombre) && raza.equals(otro.raza);
	}

	@Override
	public int compareTo(Personaje otro) {
		// Ordenado de MENOR a MAYOR salud
		return Double.compare(this.puntosSalud, otro.puntosSalud);
	}

	@Override
	public abstract String toString();
}
