package ciudad;

/**
 * Superclase abstracta base para toda la flota de drones.
 */
public abstract class Dron implements Comparable<Dron> {
	private String matricula;
	private String marca;
	private double precio;
	private boolean motoresEncendidos;

	public Dron(String matricula, String marca, double precio) {
		this.matricula = matricula;
		this.marca = marca;
		this.precio = precio;
		this.motoresEncendidos = false; // TRAMPA 1: Siempre inicializado a false
	}

	public void encender() {
		this.motoresEncendidos = true;
	}

	public void apagar() {
		this.motoresEncendidos = false;
	}

	public boolean isMotoresEncendidos() {
		return motoresEncendidos;
	}

	@Override
	public boolean equals(Object obj) { // TRAMPA 2: Igualdad correcta
		if (this == obj)
			return true;
		if (!(obj instanceof Dron))
			return false;
		Dron otro = (Dron) obj;
		return matricula.equals(otro.matricula) && marca.equals(otro.marca);
	}

	@Override
	public int compareTo(Dron otro) { // TRAMPA 3: Orden de MENOR a MAYOR
		return Double.compare(this.precio, otro.precio);
	}

	@Override
	public abstract String toString();
}
