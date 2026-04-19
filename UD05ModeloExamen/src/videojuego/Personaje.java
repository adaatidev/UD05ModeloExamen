package videojuego;

public abstract class Personaje implements Comparable<Personaje> {
	private String nombre;
	private String raza;
	private int nivel;
	private int puntosVida;
	private boolean vivo;

	public Personaje(String nombre, String raza, int nivel) {
		this.nombre = nombre;
		this.raza = raza;
		this.nivel = nivel;
		this.puntosVida = 100; // Siempre empiezan con 100 de vida
		this.vivo = true; // Siempre empiezan vivos
	}

	public void recibirDano(int dano) {
		this.puntosVida = Math.max(0, puntosVida - dano);
		if (this.puntosVida == 0) {
			this.vivo = false;
		}
	}

	public void revivir() {
		this.vivo = true;
		this.puntosVida = 100;
	}

	// Lo usaremos para forzar el error en el apartado D
	public void matar() {
		this.vivo = false;
		this.puntosVida = 0;
	}

	public boolean isVivo() {
		return vivo;
	}

	public String getNombre() {
		return nombre;
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
		// Orden inverso (de MAYOR a MENOR nivel)
		return Integer.compare(otro.nivel, this.nivel);
	}

	@Override
	public abstract String toString();
}
