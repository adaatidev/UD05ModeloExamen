package parque;

public class CochesChoque extends Atraccion implements Mecanica {
	private int velocidad = 0;

	public CochesChoque(String id, String nombre, double precio) {
		super(id, nombre, precio);
	}

	@Override
	public void acelerar() throws AtraccionDetenidaException {
		if (!isEnMarcha())
			throw new AtraccionDetenidaException();
		this.velocidad = Math.min(15, velocidad + 5);
	}

	@Override
	public void frenar() throws AtraccionDetenidaException {
		if (!isEnMarcha())
			throw new AtraccionDetenidaException();
		this.velocidad = Math.max(0, velocidad - 5);
	}

	@Override
	public String toString() {
		return String.format("[Coches Choque] Vel: %d km/h | Estado: %b", velocidad, isEnMarcha());
	}
}
