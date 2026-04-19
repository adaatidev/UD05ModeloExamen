package hospital;

public class MaquinaRayosX extends EquipoMedico implements AlertaMedica {
	private String[] modosEscaneo = { "TÓRAX", "CRÁNEO", "ABDOMEN", "EXTREMIDADES" };
	private int modoActual = 0;
	private boolean alarmaActiva = false;
	private String codigoAlerta = "";

	public MaquinaRayosX(String numSerie, String fabricante, double coste) {
		super(numSerie, fabricante, coste);
	}

	public void rotarModoEscaneo() {
		// Lógica circular para alternar modos
		modoActual = (modoActual + 1) % modosEscaneo.length;
	}

	@Override
	public void activarAlarma(String codigo) throws EquipoDesconectadoException {
		if (!isConectado())
			throw new EquipoDesconectadoException();
		this.alarmaActiva = true;
		this.codigoAlerta = codigo;
	}

	@Override
	public void desactivarAlarma() throws EquipoDesconectadoException {
		if (!isConectado())
			throw new EquipoDesconectadoException();
		this.alarmaActiva = false;
	}

	@Override
	public boolean isAlarmaActiva() {
		return alarmaActiva;
	}

	@Override
	public String toString() {
		return String.format("[Rayos X] Escaneando: %s | Alarma: %b (%s)", modosEscaneo[modoActual], alarmaActiva,
				alarmaActiva ? codigoAlerta : "OK");
	}
}
