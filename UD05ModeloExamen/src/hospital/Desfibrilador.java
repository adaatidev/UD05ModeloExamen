package hospital;

public class Desfibrilador extends EquipoMedico implements Regulable {
	private int julios = 0;

	public Desfibrilador(String numSerie, String fabricante, double coste) {
		super(numSerie, fabricante, coste);
	}

	@Override
	public void aumentarPotencia() throws EquipoDesconectadoException {
		if (!isConectado())
			throw new EquipoDesconectadoException();
		this.julios = Math.min(360, julios + 50); // Máximo real clínico
	}

	@Override
	public void disminuirPotencia() throws EquipoDesconectadoException {
		if (!isConectado())
			throw new EquipoDesconectadoException();
		this.julios = Math.max(0, julios - 50);
	}

	@Override
	public String toString() {
		return String.format("[Desfibrilador] Carga: %d J | Conectado: %b", julios, isConectado());
	}
}
