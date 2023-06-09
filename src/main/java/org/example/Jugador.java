package org.example;

import java.util.ArrayList;

public class Jugador {

	private ArrayList<Carta> mano;
	private int puntos;

	public Jugador() {
		mano = new ArrayList<Carta>();
		this.puntos = 0;
	}

	public ArrayList<Carta> getMano() {
		return this.mano;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void mostrarMano(){
		System.out.println("las cartas de este jugador son: ");
		for (Carta carta : mano) {
			System.out.println("Pinta: "+ carta.getPinta()+" || indice: "+ carta.getIndice());
		}
	}

	public void actualizarPuntos() {
		int puntaje = 0;
		for (Carta carta : this.mano){
			puntaje+=carta.getValor();
		}
		this.puntos = puntaje;
	}

	public void añadirCarta(Carta carta){
		this.mano.add(carta);
	}

}