package parque;

public class Noria extends Atraccion {
	private String[] modosGiro = { "EMBARQUE", "PANORÁMICA", "RÁPIDA" };
	private int modoActual = 0;

	public Noria(String id, String nombre, double precio) {
		super(id, nombre, precio);
	}

	public void cambiarModo() {
		this.modoActual = (modoActual + 1) % modosGiro.length; // Ciclo modular infinito
	}

	@Override
	public String toString() {
		return String.format("[Noria] Modo actual: %s | Estado: %b", modosGiro[modoActual], isEnMarcha());
	}
}
