package hospital;

/** Comportamiento para equipos de monitorización y diagnóstico */
public interface AlertaMedica {
	void activarAlarma(String codigo) throws EquipoDesconectadoException;

	void desactivarAlarma() throws EquipoDesconectadoException;

	boolean isAlarmaActiva();
}
