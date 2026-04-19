package gestion_cocina;

import cocina.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// a) Crear la tabla con al menos uno de cada
		Electrodomestico[] inventario = { new Microondas("MIC-01", "Samsung", 150.0),
				new Cafetera("CAF-99", "DeLonghi", 399.0, "Arábica 100%"),
				new HornoInteligente("HOR-55", "Bosch", 550.0), new CampanaExtractora("CAM-12", "Balay", 200.0) };

		// b) Ordenar por precio (de mayor a menor) y mostrar
		Arrays.sort(inventario);
		System.out.println("--- ELECTRODOMÉSTICOS POR PRECIO (MAYOR A MENOR) ---");
		for (Electrodomestico e : inventario) {
			System.out.println(e); // Se imprimirá usando el toString de cada subclase
		}

		// c) Recorrer, encender, aplicar lógicas protegidas y mostrar
		System.out.println("\n--- INICIANDO PREPARACIÓN DE COMIDA ---");
		for (Electrodomestico e : inventario) {
			e.encender(); // PASO CLAVE: Si olvidas esto, todas las acciones lanzarán error

			try {
				if (e instanceof Ajustable a) {
					a.subirNivel();
					a.subirNivel(); // Subimos dos veces
				}

				if (e instanceof Programable p) {
					p.iniciarPrograma("Receta Automática");
				}

				if (e instanceof HornoInteligente h) {
					h.rotarModoCalor(); // Ciclo de modos
				}

			} catch (ElectrodomesticoApagadoException ex) {
				System.out.println(ex);
			}

			System.out.println(e); // Muestra el estado final
		}

		// d) Provocar el error intencionadamente (Apartado D del examen)
		System.out.println("\n--- PRUEBA DE CAPTURA DE ERROR ---");
		Microondas microRoto = new Microondas("MIC-ERROR", "LG", 100.0);
		microRoto.apagar(); // Nos aseguramos de apagarlo

		try {
			System.out.println("Intentando calentar comida con microondas apagado...");
			microRoto.subirNivel();
		} catch (ElectrodomesticoApagadoException ex) {
			// El examen dice: "Captura el error y muéstralo"
			System.out.println("Error capturado con éxito: " + ex);
		}
	}
}
