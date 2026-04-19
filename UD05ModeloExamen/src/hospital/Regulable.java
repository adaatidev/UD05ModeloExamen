package hospital;

/** Comportamiento para equipos que administran cargas o gases */
public interface Regulable {
	void aumentarPotencia() throws EquipoDesconectadoException;

	void disminuirPotencia() throws EquipoDesconectadoException;
}
