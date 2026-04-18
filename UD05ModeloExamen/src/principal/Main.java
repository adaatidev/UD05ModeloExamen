package principal;

import domotica.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// Creación de un array Dispositivo con todos los tipos
		Dispositivo[] inventario = { new Altavoz("Echo Dot", "Amazon", 49.90, "Alexa"),
				new Luz("Hue LED", "Philips", 15.50, "Blanco"), new Termostato("Nest v3", "Google", 199.00),
				new Camara("Stick Up Cam", "Ring", 89.00, "1080p") };

		// Se ordena el array por precio
		System.out.println("--- CATÁLOGO ORDENADO POR PRECIO ---");
		Arrays.sort(inventario);
		for (Dispositivo d : inventario)
			System.out.println(d);

		// Recorre el array y realiza todas las funciones para probarlas
		System.out.println("--- EJECUTANDO ACCIONES ---");
		for (Dispositivo d : inventario) {
			// Enciende el dispositivo
			d.encender();
			try {
				// Si el dispositivo es un altavoz
				if (d instanceof Altavoz a) {
					// Subir dos veces el nivel
					a.subirNivel();
					a.subirNivel();
					System.out.println("Asistente del altavoz: " + a.getAsistente());
					// Si el dispositivo es una luz
				} else if (d instanceof Luz l) {
					// Se sube el nivel y se cambia el color
					l.subirNivel();
					l.setColor("Rojo");
					// Si el dispositivo es un termostato
				} else if (d instanceof Termostato t) {
					// Cambiar el modo y activar la alerta con un mensaje
					t.cambiarModo();
					t.activarAlerta("¡Temperatura alta!");
					// Si el dispositivo es una cámara
				} else if (d instanceof Camara c) {
					// Inicia la grabación y activar la alerta con un mensaje
					c.iniciarGrabacion();
					c.activarAlerta("¡Movimiento detectado!");
				}
			} catch (DispositivoApagadoException e) {
				System.out.println(e);
			}
			System.out.println(d);
		}

		// Forzando un caso de error
		System.out.println("--- PRUEBA DE ERROR ---");
		Altavoz prueba = new Altavoz("Sonos One", "Sonos", 229.00, "Google");
		// Apagar el altavoz
		prueba.apagar();
		try {
			System.out.println("Intentando subir volumen con altavoz apagado...");
			prueba.subirNivel();
		} catch (DispositivoApagadoException e) {
			System.out.println("Capturado con éxito: " + e); // Muestra el mensaje de error
		}
	}
}
