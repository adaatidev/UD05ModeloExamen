package hospital;

public class MonitorConstantes extends EquipoMedico implements AlertaMedica {
	private String nombrePaciente;
	private boolean alarmaActiva = false;
	private String codigoAlerta = "";

	public MonitorConstantes(String numSerie, String fabricante, double coste, String paciente) {
		super(numSerie, fabricante, coste);
		this.nombrePaciente = paciente;
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
		return String.format("[Monitor] Paciente: %s | Alarma: %b (%s)", nombrePaciente, alarmaActiva,
				alarmaActiva ? codigoAlerta : "OK");
	}
}
