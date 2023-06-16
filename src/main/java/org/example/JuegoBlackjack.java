package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class JuegoBlackjack {

	public static void jugar(){
		System.out.println("Recuerde que en cada partida usted es el jugador 1 (J1)");
		ArrayList<Carta> naipe = crearNaipe();
		Collections.shuffle(naipe);
		JugadorBlackjack ji = new JugadorBlackjack();
		JugadorBlackjack j2 = new JugadorBlackjack();
		ji = repartirInicial(ji, naipe);
		naipe = removerCartas(3,naipe);
		j2 = repartirInicial(j2, naipe);
		naipe = removerCartas(3,naipe);
		ji.mostrarMano();
		j2.mostrarMano();
		ji.actualizarPuntos();
		j2.actualizarPuntos();
		System.out.println("puntos j1: "+ji.getPuntos());
		System.out.println("puntos j2: "+j2.getPuntos());
		seleccionarGanador(ji,j2);


	}

	public static ArrayList<Carta> crearNaipe() {
		String[] pintas = {"Corazon","Diamante","Trebol","Pica"};
		//el valor 10 se cambio por una D ya que el arreglo es de char
		char[] indices = {'A','2','3','4','5','6','7','8','9','D','J','Q','K'};
		//se tiene en cuenta que el valor del A es 11 y la J,Q,K son 10 cada uno
		int[] valores = {11,2,3,4,5,6,7,8,9,10,10,10,10};
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		for (String pinta : pintas){
			//aqui se usa un for normal ya que necesito hacer una carta que tenga el valor de su respectivo indice
			//sino se crearian todas las combinaciones como un 2 con un valor 11, uno con valor 2,3,4,5,6,etc.
			for (int i = 0; i<13 ;i++){
				cartas.add(new Carta(pinta,indices[i],valores[i]));
			}
		}
		return cartas;
	}

	/**
	 *
	 * @param jugadorBlackjack
	 */
	public static JugadorBlackjack repartirInicial(JugadorBlackjack jugadorBlackjack, ArrayList<Carta> naipe) {
		for (int i = 0; i<3 ; i++){
			jugadorBlackjack.añadirCarta(naipe.get(i));
		}
		return jugadorBlackjack;
	}


	public static void seleccionarGanador(JugadorBlackjack j1, JugadorBlackjack j2) {

		if (j1.getPuntos()>21 && j2.getPuntos()>21){
			System.out.println("Ambos jugadores pierden, la casa gana");
		} else if (j1.getPuntos()<=21 && j2.getPuntos()>21) {
			System.out.println("El jugador 1 gana");
		} else if (j1.getPuntos()>21 && j2.getPuntos()<=21) {
			System.out.println("El jugador 2 gana");
		} else if (j1.getPuntos()> j2.getPuntos()) {
			System.out.println("El jugador 1 gana");
		}else {
			System.out.println("El jugador 2 gana");
		}
	}

	public static ArrayList<Carta> removerCartas (int cantCartasRetiradas, ArrayList<Carta> naipe){
		for (int i = 0; i < cantCartasRetiradas; i++){
			naipe.remove(0);
		}
		return naipe;
	}

}