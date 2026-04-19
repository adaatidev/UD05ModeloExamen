package juego;

/** Comportamiento para personajes mágicos que canalizan poder */
public interface Hechizable {
	void activarAura(String tipo) throws EstadoPacificoException;

	void desactivarAura() throws EstadoPacificoException;

	boolean isAuraActiva();
}
