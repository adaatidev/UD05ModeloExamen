package biblioteca;

public class RevistaCientifica extends Recurso implements Consultable {
	private String[] areas = { "IA", "BIOLOGÍA", "FÍSICA", "QUÍMICA" };
	private int areaActual = 0;

	public RevistaCientifica(String isbn, String titulo, String autor, double precio) {
		super(isbn, titulo, autor, precio);
	}

	public void siguienteArea() {
		// Lógica circular para cambiar el área de estudio
		this.areaActual = (areaActual + 1) % areas.length;
	}

	@Override
	public void abrirConsulta() throws RecursoNoDisponibleException {
		if (isPrestado())
			throw new RecursoNoDisponibleException();
		System.out.println("Consulta abierta en sala para: " + getTitulo());
	}

	@Override
	public void cerrarConsulta() {
		System.out.println("Consulta finalizada.");
	}

	@Override
	public String toString() {
		return "[Revista] " + getTitulo() + " | Área: " + areas[areaActual];
	}
}
