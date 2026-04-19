package cocina;

/**
 * Superclase base para todos los electrodomésticos del catálogo.
 */
public abstract class Electrodomestico implements Comparable<Electrodomestico> {
	private String numSerie;
	private String marca;
	private double precio;
	private boolean encendido;

	public Electrodomestico(String numSerie, String marca, double precio) {
		this.numSerie = numSerie;
		this.marca = marca;
		this.precio = precio;
		this.encendido = false; // Comienza siempre apagado
	}

	public void encender() {
		this.encendido = true;
	}

	public void apagar() {
		this.encendido = false;
	}

	public boolean isEncendido() {
		return encendido;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Electrodomestico))
			return false;
		Electrodomestico otro = (Electrodomestico) obj;
		return numSerie.equals(otro.numSerie) && marca.equals(otro.marca);
	}

	@Override
	public int compareTo(Electrodomestico otro) {
		// Ordenado de MAYOR a MENOR precio (invertimos el orden de this y otro)
		return Double.compare(otro.precio, this.precio);
	}

	@Override
	public abstract String toString();
}
