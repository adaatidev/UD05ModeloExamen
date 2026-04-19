package gestion_flota;

import flota.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// a) Crear la tabla capaz de contener cualquier nave
		Nave[] escuadron = { new CazaCombate("X-01", "Alianza", 15.5, "Láser Doble"),
				new Acorazado("D-99", "Imperio", 5000.0, 120), new Carguero("C-55", "Alianza", 1200.0, 8000.0),
				new NaveExploracion("E-09", "Federación", 45.0) };

		// b) Ordenar por tonelaje y mostrar
		Arrays.sort(escuadron);
		System.out.println("--- FLOTA ORDENADA POR TONELAJE ---");
		for (Nave n : escuadron) {
			System.out.println(n);
		}

		// c) Recorrer la tabla y aplicar lógica con protección de errores
		System.out.println("\n--- INICIANDO MANIOBRAS ---");
		for (Nave n : escuadron) {
			n.encenderMotores(); // Encender antes de operar

			try {
				if (n instanceof Navegable nav) {
					nav.acelerar();
					nav.acelerar(); // Aceleramos dos veces
				}

				if (n instanceof Defendible def) {
					def.activarEscudos("MÁXIMA POTENCIA");
				}

				if (n instanceof NaveExploracion exp) {
					exp.rotarRadar(); // Cambio de modo cíclico
				}

			} catch (MotoresApagadosException e) {
				System.out.println(e);
			}

			// Imprimir la nave al final del ciclo
			System.out.println(n);
		}

		// d) Prueba de fallo forzado
		System.out.println("\n--- PRUEBA DE BLOQUEO DE MOTOR ---");
		CazaCombate averiado = new CazaCombate("X-ERROR", "Pirata", 10.0, "Plasma");
		averiado.apagarMotores(); // Forzamos el estado a apagado

		try {
			System.out.println("Intentando acelerar con motores apagados...");
			averiado.acelerar();
		} catch (MotoresApagadosException e) {
			System.out.println("Fallo interceptado correctamente: " + e);
		}
	}
}
