package gestion_biblioteca;

import biblioteca.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// a) Tabla con recursos
		Recurso[] inventario = { new Ebook("111-A", "Java para DAM", "Autor A", 20.0, "EPUB"),
				new RevistaCientifica("222-B", "Nature IA", "Varios", 15.0),
				new Ebook("000-C", "Aprende Python", "Autor B", 25.0, "PDF") };

		// b) Ordenar (alfabéticamente) y mostrar
		Arrays.sort(inventario);
		System.out.println("--- CATÁLOGO ORDENADO ---");
		for (Recurso r : inventario)
			System.out.println(r);

		// c) Recorrer y aplicar acciones
		System.out.println("\n--- PROCESANDO RECURSOS ---");
		for (Recurso r : inventario) {
			// No lo prestamos para que se pueda descargar/consultar
			try {
				if (r instanceof Descargable d) {
					d.descargar();
				}

				if (r instanceof RevistaCientifica rev) {
					rev.siguienteArea();
					rev.abrirConsulta();
				}
			} catch (RecursoNoDisponibleException e) {
				System.out.println(e);
			}
			System.out.println(r);
		}

		// d) Prueba de error forzada
		System.out.println("\n--- PRUEBA DE ERROR (APARTADO D) ---");
		Ebook bloqueado = new Ebook("999-Z", "Libro Prohibido", "Anonimo", 50.0, "PDF");
		bloqueado.prestar(); // Lo marcamos como prestado (bloqueado)

		try {
			System.out.println("Intentando descargar recurso prestado...");
			bloqueado.descargar();
		} catch (RecursoNoDisponibleException e) {
			System.out.println("Capturado: " + e);
		}
	}
}
