package flota;

/**
 * Clase base que define la estructura y propiedades comunes de toda la flota.
 */
public abstract class Nave implements Comparable<Nave> {
	private String matricula;
	private String faccion;
	private double tonelaje;
	private boolean motoresEncendidos;

	public Nave(String matricula, String faccion, double tonelaje) {
		this.matricula = matricula;
		this.faccion = faccion;
		this.tonelaje = tonelaje;
		this.motoresEncendidos = false; // Estado inicial obligatorio
	}

	public void encenderMotores() {
		this.motoresEncendidos = true;
	}

	public void apagarMotores() {
		this.motoresEncendidos = false;
	}

	public boolean isMotoresEncendidos() {
		return motoresEncendidos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Nave))
			return false;
		Nave otra = (Nave) obj;
		return matricula.equals(otra.matricula) && faccion.equals(otra.faccion);
	}

	@Override
	public int compareTo(Nave otra) {
		// Orden natural: de menor a mayor tonelaje
		return Double.compare(this.tonelaje, otra.tonelaje);
	}

	@Override
	public abstract String toString();
}
