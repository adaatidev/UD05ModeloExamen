package videojuego;

/** Comportamiento para personajes que usan maná o magia */
interface LanzadorMagia {
	void lanzarHechizo() throws PersonajeMuertoException;

	void recuperarMana();
}
