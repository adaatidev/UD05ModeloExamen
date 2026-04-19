package hospital;

/**
 * Superclase abstracta que define las propiedades de cualquier aparato clínico.
 */
public abstract class EquipoMedico implements Comparable<EquipoMedico> {
	private String numSerie;
	private String fabricante;
	private double coste;
	private boolean conectado;

	public EquipoMedico(String numSerie, String fabricante, double coste) {
		this.numSerie = numSerie;
		this.fabricante = fabricante;
		this.coste = coste;
		this.conectado = false; // Comienza siempre desconectado
	}

	public void conectar() {
		this.conectado = true;
	}

	public void desconectar() {
		this.conectado = false;
	}

	public boolean isConectado() {
		return conectado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof EquipoMedico))
			return false;
		EquipoMedico otro = (EquipoMedico) obj;
		return numSerie.equals(otro.numSerie) && fabricante.equals(otro.fabricante);
	}

	@Override
	public int compareTo(EquipoMedico otro) {
		// Ordenado de MENOR a MAYOR coste
		return Double.compare(this.coste, otro.coste);
	}

	@Override
	public abstract String toString();
}
