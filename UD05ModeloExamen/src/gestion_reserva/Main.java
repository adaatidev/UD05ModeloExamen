package gestion_reserva;

import reserva.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// a) Tabla de animales
		Animal[] catalogo = { new Leon("L-01", 8, 25.5), new Elefante("E-99", 12, 40.0), new Aguila("A-05", 3, 2.1),
				new Leon("L-02", 5, 15.0) };

		// b) Ordenar por edad y mostrar
		Arrays.sort(catalogo);
		System.out.println("--- ANIMALES ORDENADOS POR EDAD ---");
		for (Animal a : catalogo)
			System.out.println(a);

		// c) Recorrer y aplicar acciones
		System.out.println("\n--- INICIANDO PROTOCOLO DE REHABILITACIÓN ---");
		for (Animal a : catalogo) {
			a.liberar(); // Paso obligatorio para que no salte la excepción

			try {
				if (a instanceof Entrenable e) {
					e.realizarTruco();
					System.out.println("Animal entrenado. Nivel: " + e.obtenerNivelObediencia());
				}

				if (a instanceof Localizable l) {
					l.registrarCoordenadas(37.38, -5.98);
				}

				// Acción específica si es Elefante
				if (a instanceof Elefante el) {
					el.cambiarModo();
				}

			} catch (AccionNoPermitidaException ex) {
				System.out.println(ex);
			}
			System.out.println(a);
		}

		// d) Prueba de error (Animal recluido)
		System.out.println("\n--- PRUEBA DE ERROR (APARTADO D) ---");
		Leon salvaje = new Leon("WILD-1", 10, 30.0);
		salvaje.recluir(); // Forzamos el estado a falso

		try {
			System.out.println("Intentando entrenar león en cautividad...");
			salvaje.realizarTruco();
		} catch (AccionNoPermitidaException e) {
			System.out.println("Resultado: " + e); // Muestra "Error: El animal no está en libertad."
		}
	}
}
