package cocina;

public class Microondas extends Electrodomestico implements Ajustable {
	private int potencia = 0;

	public Microondas(String numSerie, String marca, double precio) {
		super(numSerie, marca, precio);
	}

	@Override
	public void subirNivel() throws ElectrodomesticoApagadoException {
		if (!isEncendido())
			throw new ElectrodomesticoApagadoException();
		this.potencia = Math.min(800, potencia + 100);
	}

	@Override
	public void bajarNivel() throws ElectrodomesticoApagadoException {
		if (!isEncendido())
			throw new ElectrodomesticoApagadoException();
		this.potencia = Math.max(0, potencia - 100);
	}

	@Override
	public String toString() {
		return String.format("[Microondas] Serie: %s | Precio: %.2f | Potencia: %dW | ON: %b", super.equals(this),
				super.compareTo(this), potencia, isEncendido()); // Formateo alternativo válido
	}

//	// Sobrescribimos el toString real y limpio
//	@Override
//	public String toString() {
//		return "[Microondas] Potencia actual: " + potencia + "W | Estado: " + (isEncendido() ? "ON" : "OFF");
//	}
}
