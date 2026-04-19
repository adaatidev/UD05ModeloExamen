package gestion_transporte;

import java.util.Arrays;

import transporte.AutobusElectrico;
import transporte.Localizable;
import transporte.Patinete;
import transporte.Recargable;
import transporte.TrenMetro;
import transporte.Vehiculo;
import transporte.VehiculoFueraDeServicioException;

public class Main {
	public static void main(String[] args) {
		// a) Tabla con todos los tipos
		Vehiculo[] flota = { new AutobusElectrico("BUS-01", "Mercedes", 150.0, 14),
				new Patinete("PAT-99", "Xiaomi", 20.0), new TrenMetro("MET-05", "CAF", 1000.0, 6),
				new AutobusElectrico("BUS-02", "BYD", 385.0, 27) };

		// b) Ordenar por autonomía (Mayor a Menor) y mostrar
		Arrays.sort(flota);
		System.out.println("--- FLOTA ORDENADA POR AUTONOMÍA ---");
		for (Vehiculo v : flota)
			System.out.println(v);

		// c) Recorrer y ejecutar acciones
		System.out.println("\n--- PONIENDO EN MARCHA LA FLOTA ---");
		for (Vehiculo v : flota) {
			v.ponerEnServicio(); // Paso previo obligatorio

			try {
				if (v instanceof Recargable r) {
					r.cargarBateria();
					System.out.println("Cargando batería de: " + v.getClass().getSimpleName());
				}

				if (v instanceof Localizable l) {
					l.actualizarCoordenadas(40.416, -3.703);
					System.out.println("Localización actualizada: " + l.obtenerUbicacion());
				}
			} catch (VehiculoFueraDeServicioException e) {
				System.out.println(e);
			}
			System.out.println(v);
		}

		// d) Prueba de error forzada (Apartado D)
		System.out.println("\n--- PRUEBA DE CONTROL DE ERRORES ---");
		Patinete roto = new Patinete("ERROR-01", "Generic", 5.0);
		roto.retirarDeServicio(); // Forzamos fuera de servicio

		try {
			System.out.println("Intentando cargar patinete fuera de servicio...");
			roto.cargarBateria();
		} catch (VehiculoFueraDeServicioException e) {
			System.out.println("Capturado con éxito: " + e);
		}
	}
}
