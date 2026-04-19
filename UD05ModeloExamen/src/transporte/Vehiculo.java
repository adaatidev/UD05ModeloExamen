package transporte;

import java.util.Objects;

/**
 * Superclase abstracta que define las propiedades comunes de la flota.
 */
public abstract class Vehiculo implements Comparable<Vehiculo> {
	private String id;
	private String marca;
	private double autonomia;
	private boolean enServicio;

	// Constructor con parámetros
	public Vehiculo(String id, String marca, double autonomia) {
		this.id = id;
		this.marca = marca;
		this.autonomia = autonomia;
		this.enServicio = false;
	}

	// Getters y setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}

	public void ponerEnServicio() {
		this.enServicio = true;
	}

	public void retirarDeServicio() {
		this.enServicio = false;
	}

	public boolean isEnServicio() {
		return enServicio;
	}

	/**
	 * Método equals que devuelve true si ambos objetos son iguales en id y marca
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(id, other.id) && Objects.equals(marca, other.marca);
	}

	/**
	 * Método compareTo para ordenar su autonomía de mayor a menor
	 */
	@Override
	public int compareTo(Vehiculo otro) {
		return Double.compare(this.autonomia, otro.autonomia);
	}

	@Override
	public abstract String toString();
}
