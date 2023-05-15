package org.example;

public class Jugador {

	private Carta[] mano;
	private int puntos;

	public Carta[] getMano() {
		return this.mano;
	}

	public void setMano(Carta[] mano) {
		this.mano = mano;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}