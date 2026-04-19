package parque;

/**
 * Superclase que agrupa las características comunes de todas las instalaciones
 * del parque.
 */
public abstract class Atraccion implements Comparable<Atraccion> {
	private String id;
	private String nombre;
	private double precioEntrada;
	private boolean enMarcha;

	public Atraccion(String id, String nombre, double precioEntrada) {
		this.id = id;
		this.nombre = nombre;
		this.precioEntrada = precioEntrada;
		this.enMarcha = false; // Comienza siempre detenida
	}

	public void arrancar() {
		this.enMarcha = true;
	}

	public void detener() {
		this.enMarcha = false;
	}

	public boolean isEnMarcha() {
		return enMarcha;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Atraccion))
			return false;
		Atraccion otra = (Atraccion) obj;
		return id.equals(otra.id) && nombre.equals(otra.nombre);
	}

	@Override
	public int compareTo(Atraccion otra) {
		// Ordenar de MAYOR a MENOR precio (se invierte el orden: otra vs this)
		return Double.compare(otra.precioEntrada, this.precioEntrada);
	}

	@Override
	public abstract String toString();
}
