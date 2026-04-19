package principal;

public class UML {

//	CLASE PARA EXCEPTION
//	DispositivoApagadoException
//	-----------------------------
//	+ public String toString()
//	-----------------------------
//
//	INTERFAZ
//	ModificarNivel
//	--------------------------------------------------------
//	+ void subirNivel() throws DispositivoApagadoException;
//	+ void bajarNivel() throws DispositivoApagadoException;
//	--------------------------------------------------------
//
//	INTERFAZ
//	EmitirAlerta
//	-------------------------------------------------------------------------
//	+ void activarAlerta(String mensaje) throws DispositivoApagadoException;
//	+ void desactivarAlerta() throws DispositivoApagadoException;
//	+boolean isAlertaActiva();
//	-------------------------------------------------------------------------
//
//	SUPERCLASE:
//	<<abstract>> Dispositivo
//	-------------------------------
//	- nombre:	String
//	- marca:	String
//	- precio:	double
//	- encendido:	boolean (SIEMPRE ESTÁ APAGADO, CUALQUIER DISPOSITIVO PUEDE ENCENDERSE Y APAGARSE)
//	-------------------------------
//	+ abstract toString()
//	+ equals(Object obj)
//	+ compareTo(Dispositivo otro)
//	-------------------------------
//
//	SUBCLASES:
//	Altavoz
//	---------------------------
//	- UDS:		final int
//	- asistente:	String
//	- volumen:	int
//	---------------------------
//	+ getAsistente()
//	---------------------------
//	+ subirNivel()
//	+ bajarNivel()
//	+ toString()
//	---------------------------
//
//	Luz
//	---------------------------
//	- UDS:		final int
//	- color:	String
//	- brillo:	int
//	----------------------------
//	+ setColor()
//	----------------------------
//	+ subirNivel()
//	+ bajarNivel()
//	+ toString()
//	----------------------------
//
//	Termostato
//	---------------------------------------
//	- tempObjetivo: 	double
//	- modos[]:		array String
//	- modoActual:		int
//	- alertaActiva:		boolean false
//	- mensajeAlerta:	String
//	---------------------------------------
//	+ cambiarModo()
//	+ activarAlerta()
//	+ desactivarAlerta()
//	+ isAlertaActiva()
//	+ toString()
//	---------------------------------------
//
//	Camara
//	---------------------------------------
//	- resolución:		String
//	- grabando		boolean false
//	- alertaActiva:		boolean false
//	- mensajeAlerta:	String
//	---------------------------------------
//	+ void iniciarGrabacion();
//	+ void detenerGrabacion();
//	+ activarAlerta()
//	+ desactivarAlerta()
//	+ isAlertaActiva()
//	+ toString()
//	---------------------------------------
	
}
