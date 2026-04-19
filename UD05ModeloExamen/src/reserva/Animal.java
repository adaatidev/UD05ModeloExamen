package reserva;

/**
 * Superclase que define los rasgos comunes de todos los animales.
 */
public abstract class Animal implements Comparable<Animal> {
	private String id;
	private String especie;
	private int edad;
	private boolean enLibertad;

	public Animal(String id, String especie, int edad) {
		this.id = id;
		this.especie = especie;
		this.edad = edad;
		this.enLibertad = false; // Por defecto en cautividad
	}

	// Métodos para gestionar el estado (cruciales para que el Main no de error)
	public void liberar() {
		this.enLibertad = true;
	}

	public void recluir() {
		this.enLibertad = false;
	}

	public boolean isEnLibertad() {
		return enLibertad;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal))
			return false;
		Animal otro = (Animal) obj;
		return id.equals(otro.id) && especie.equals(otro.especie);
	}

	@Override
	public int compareTo(Animal otro) {
		// Ordenar por edad de menor a mayor
		return Integer.compare(this.edad, otro.edad);
	}

	@Override
	public abstract String toString();
}
