package gestion_ciudad;

import ciudad.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// a) Tabla polimórfica
		Dron[] escuadron = { new DronExplorador("DR-EXP-1", "DJI", 1200.0),
				new DronVigilancia("DR-VIG-9", "Parrot", 800.0), new DronReparto("DR-REP-5", "Amazon", 3500.0, 15.0),
				new DronAgricola("DR-AGR-2", "Yuneec", 4500.0, "Nitratos") };

		// b) Ordenar y mostrar
		Arrays.sort(escuadron);
		System.out.println("--- ESCUADRÓN ORDENADO POR PRECIO ---");
		for (Dron d : escuadron) {
			System.out.println(d);
		}

		// c) Bucle principal (Encender, Operar con seguridad, Mostrar)
		System.out.println("\n--- INICIANDO PROTOCOLO DE VUELO ---");
		for (Dron d : escuadron) {
			d.encender(); // TRAMPA 7: Encender SIEMPRE antes del try-catch

			try {
				// TRAMPA 8: Uso de instanceof para comportamientos específicos
				if (d instanceof Vuelo v) {
					v.subirAltitud();
					v.subirAltitud(); // Subimos dos veces como pedía el examen
				}

				if (d instanceof Camara c) {
					c.iniciarGrabacion("4K 60FPS");
				}

				if (d instanceof DronVigilancia vig) {
					vig.rotarFiltro(); // Aplicar el ciclo
				}

			} catch (MotoresApagadosException e) {
				System.out.println(e);
			}

			// TRAMPA 9: El toString se imprime SIEMPRE al final de la iteración
			System.out.println(d);
		}

		// d) Prueba de error forzado (Apartado D del examen real)
		System.out.println("\n--- PRUEBA DE FALLO DE MOTORES ---");
		DronExplorador dronAveriado = new DronExplorador("ERR-404", "Generic", 500.0);
		dronAveriado.apagar(); // Aseguramos el estado en false

		try {
			System.out.println("Intentando despegar con motores apagados...");
			dronAveriado.subirAltitud();
		} catch (MotoresApagadosException e) {
			System.out.println("Seguridad activada. Error capturado: " + e);
		}
	}
}
