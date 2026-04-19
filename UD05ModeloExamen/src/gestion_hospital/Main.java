package gestion_hospital;

import hospital.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// a) Declarar tabla polimórfica
		EquipoMedico[] uci = { new Respirador("R-001", "Medtronic", 15000.0),
				new Desfibrilador("D-552", "Philips", 8500.0),
				new MonitorConstantes("M-999", "GE Healthcare", 3200.0, "Juan Pérez"),
				new MaquinaRayosX("X-888", "Siemens", 45000.0) };

		// b) Ordenar por coste y mostrar
		Arrays.sort(uci);
		System.out.println("--- EQUIPAMIENTO ORDENADO POR COSTE ---");
		for (EquipoMedico equipo : uci) {
			System.out.println(equipo);
		}

		// c) Recorrer, conectar, operar y proteger errores
		System.out.println("\n--- INICIANDO RONDA MÉDICA ---");
		for (EquipoMedico equipo : uci) {
			equipo.conectar(); // Precondición vital

			try {
				if (equipo instanceof Regulable reg) {
					reg.aumentarPotencia();
					reg.aumentarPotencia(); // Pedían aplicarlo dos veces en el original
				}

				if (equipo instanceof AlertaMedica alerta) {
					alerta.activarAlarma("CÓDIGO AZUL"); // Activamos la alarma
				}

				if (equipo instanceof MaquinaRayosX rayosX) {
					rayosX.rotarModoEscaneo(); // Probamos la lógica circular
				}

			} catch (EquipoDesconectadoException e) {
				System.out.println(e);
			}

			// Imprimir tras aplicar cambios
			System.out.println(equipo);
		}

		// d) Forzar el error con un equipo desconectado
		System.out.println("\n--- PRUEBA DE SEGURIDAD (APARTADO D) ---");
		Respirador urgencia = new Respirador("R-ERROR", "Medtronic", 15000.0);
		urgencia.desconectar(); // Nos aseguramos de que empiece en false

		try {
			System.out.println("Intentando aumentar oxígeno sin conectar a la pared...");
			urgencia.aumentarPotencia();
		} catch (EquipoDesconectadoException e) {
			System.out.println("Error interceptado correctamente: " + e);
		}
	}
}
