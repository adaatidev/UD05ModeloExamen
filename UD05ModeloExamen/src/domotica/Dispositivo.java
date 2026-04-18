package domotica;

public abstract class Dispositivo implements Comparable<Dispositivo> {

	// Variables que comparten todos los dispositivos
	private String nombre;
	private String marca;
	private double precio;
	private boolean encendido;

	// Constructor con parámetros
	public Dispositivo(String nombre, String marca, double precio) {
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.encendido = false;
	}

	/**
	 * Método encender que cambia el boolean de encendido a true
	 */
	public void encender() {
		this.encendido = true;
	}

	/**
	 * Método apagar que cambia el boolean de encendido a false
	 */
	public void apagar() {
		this.encendido = false;
	}

	/**
	 * Método isEncendido que devuelve si el dispositivo está encendido o no
	 */
	public boolean isEncendido() {
		return encendido;
	}

	/**
	 * Método equals que compara dos dispositivos y devuelve true si tienen el mismo
	 * nombre y marca
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Dispositivo))
			return false;
		Dispositivo d = (Dispositivo) obj;
		return nombre.equals(d.nombre) && marca.equals(d.marca);
	}

	/**
	 * Método compareTo para ordenar los dispositivos por su precio
	 */
	@Override
	public int compareTo(Dispositivo otro) {
		return Double.compare(this.precio, otro.precio);
	}

	/**
	 * Método toString que devuelve una cadena con la información
	 */
	@Override
	public String toString() {
		return String.format("[%s] %s %s - %.2f€ (Estado: %s)", getClass().getSimpleName(), marca, nombre, precio,
				encendido ? "Encendido" : "Apagado");
	}

//	// MÉTODO ABSTRACTO: Obligas a cada subclase a mostrar su info específica 
//    @Override
//    public abstract String toString();
//}

}
