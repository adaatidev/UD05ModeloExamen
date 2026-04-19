package parque;

public class MontanaRusa extends Atraccion implements Mecanica {
	private int velocidad = 0;

	public MontanaRusa(String id, String nombre, double precio) {
		super(id, nombre, precio);
	}

	@Override
	public void acelerar() throws AtraccionDetenidaException {
		if (!isEnMarcha())
			throw new AtraccionDetenidaException();
		this.velocidad = Math.min(120, velocidad + 30);
	}

	@Override
	public void frenar() throws AtraccionDetenidaException {
		if (!isEnMarcha())
			throw new AtraccionDetenidaException();
		this.velocidad = Math.max(0, velocidad - 30);
	}

	@Override
	public String toString() {
		return String.format("[Montaña Rusa] Vel: %d km/h | Estado: %b", velocidad, isEnMarcha());
	}
}
