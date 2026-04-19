package gestion_juego;

import juego.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// a) Crear la tabla con la party (grupo)
		Personaje[] gremio = { new Guerrero("Krag", "Orco", 1500.0),
				new Arquero("Legolas", "Elfo", 950.0, "Arco Largo"),
				new Clerigo("Luzbendita", "Humano", 800.0, "El Dios Sol"), new Mago("Gandalf", "Maia", 1100.0) };

		// b) Ordenar por puntos de salud (Menor a Mayor) y mostrar
		Arrays.sort(gremio);
		System.out.println("--- GREMIO ORDENADO POR SALUD ---");
		for (Personaje p : gremio) {
			System.out.println(p);
		}

		// c) Bucle principal: Entrar en combate, aplicar acciones y proteger errores
		System.out.println("\n--- ¡UN ENEMIGO SALVAJE APARECE! (Iniciando combate) ---");
		for (Personaje p : gremio) {
			p.entrarEnCombate(); // PRECONDICIÓN: vital para que no salte el catch

			try {
				if (p instanceof Entrenable fisico) {
					fisico.subirAtributo();
					fisico.subirAtributo(); // Se sube dos veces (como el volumen del altavoz)
				}

				if (p instanceof Hechizable magico) {
					magico.activarAura("AURA DE PROTECCIÓN");
				}

				if (p instanceof Mago mago) {
					mago.rotarElemento(); // Aplicar el cambio de modo
				}

			} catch (EstadoPacificoException e) {
				System.out.println(e);
			}

			// Imprimir el estado final del personaje tras actuar
			System.out.println(p);
		}

		// d) Forzar el error según el apartado D del examen
		System.out.println("\n--- PRUEBA DE ERROR FORZADO ---");
		Guerrero inactivo = new Guerrero("Arthur", "Humano", 1200.0);
		inactivo.salirDeCombate(); // Nos aseguramos de que su estado sea false

		try {
			System.out.println("Intentando que un guerrero ataque fuera de combate...");
			inactivo.subirAtributo();
		} catch (EstadoPacificoException e) {
			// Se captura e imprime el mensaje personalizado
			System.out.println("Excepción capturada correctamente: " + e);
		}
	}
}
