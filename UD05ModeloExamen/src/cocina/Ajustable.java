package cocina;

/** Capacidad para subir o bajar magnitudes numéricas */
public interface Ajustable {
	void subirNivel() throws ElectrodomesticoApagadoException;

	void bajarNivel() throws ElectrodomesticoApagadoException;
}
