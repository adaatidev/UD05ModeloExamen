package gestion_parque;

import parque.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// a) Declarar tabla polimórfica
		Atraccion[] recinto = { new MontanaRusa("MR-01", "Dragon Khan", 8.50),
				new CasaTerror("CT-99", "Mansión Maldita", 6.00, 5), new Noria("NO-05", "London Eye Clone", 12.00),
				new CochesChoque("CC-22", "Autos Locos", 4.50) };

		// b) Ordenar por precio (de mayor a menor) y mostrar
		Arrays.sort(recinto);
		System.out.println("--- ATRACCIONES ORDENADAS POR PRECIO ---");
		for (Atraccion a : recinto) {
			System.out.println(a);
		}

		// c) Recorrer, arrancar, operar y proteger errores
		System.out.println("\n--- ABRIENDO EL PARQUE ---");
		for (Atraccion a : recinto) {
			a.arrancar(); // Precondición vital

			try {
				if (a instanceof Mecanica mec) {
					mec.acelerar();
					mec.acelerar(); // El doble aumento típico del examen
				}

				if (a instanceof Tematica tem) {
					tem.iniciarEspectaculo("Noche de Zombies");
				}

				if (a instanceof Noria noria) {
					noria.cambiarModo(); // Cambiamos el estado circular
				}

			} catch (AtraccionDetenidaException e) {
				System.out.println(e);
			}

			// Imprimir tras aplicar cambios
			System.out.println(a);
		}

		// d) Forzar el error con una atracción detenida
		System.out.println("\n--- PRUEBA DE SEGURIDAD DE EMERGENCIA ---");
		MontanaRusa averiada = new MontanaRusa("MR-ERROR", "Shambhala", 10.0);
		averiada.detener(); // Aseguramos que el boolean es false

		try {
			System.out.println("Intentando lanzar tren con la atracción detenida...");
			averiada.acelerar();
		} catch (AtraccionDetenidaException e) {
			System.out.println("Seguridad activada, error capturado: " + e);
		}
	}
}
