package hospital;

public class Respirador extends EquipoMedico implements Regulable {
	private int nivelOxigeno = 20; // Nivel base

	public Respirador(String numSerie, String fabricante, double coste) {
		super(numSerie, fabricante, coste);
	}

	@Override
	public void aumentarPotencia() throws EquipoDesconectadoException {
		if (!isConectado())
			throw new EquipoDesconectadoException();
		this.nivelOxigeno = Math.min(100, nivelOxigeno + 10);
	}

	@Override
	public void disminuirPotencia() throws EquipoDesconectadoException {
		if (!isConectado())
			throw new EquipoDesconectadoException();
		this.nivelOxigeno = Math.max(0, nivelOxigeno - 10);
	}

	@Override
	public String toString() {
		return String.format("[Respirador] O2: %d%% | Conectado: %b", nivelOxigeno, isConectado());
	}
}
