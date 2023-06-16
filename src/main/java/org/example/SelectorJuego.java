package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SelectorJuego {
	public static void opcionesJuegos() {
		System.out.println("A continuación, puede elegir un juego de los siguientes para comenzar");
		System.out.println("1. Blackjack");
		System.out.println("2. Bullseye");
		System.out.println("3. Salir");
	}

	public static void ejecutar() {
		bienvenida();
		eleccionJuego();
	}

	public static void eleccionJuego() {
		Scanner in = new Scanner(System.in);
		opcionesJuegos();
		int eleccion = 1;
		boolean eleccionValida = false;

		while (!eleccionValida) {
			try {
				eleccion = in.nextInt();
				eleccionValida = Util.validarRango(eleccion, 1, 3);

				if (!eleccionValida) {
					System.out.println("Su número no está dentro de los rangos válidos, ingrese nuevamente");
				}
			} catch (InputMismatchException e) {
				System.out.println("El elemento ingresado no es válido, ingrese nuevamente");
				in.nextLine();
			}
		}

		switch (eleccion) {
			case 1:
				JuegoBlackjack.jugar();
				break;
			case 2:
				JuegoBullseye.iniciar();
				break;
			case 3:
				System.out.println("Gracias por jugar con nosotros, Casinos Deluxe. Esperamos verlo nuevamente.");
				System.exit(1);
				break;
		}
	}

	public static void bienvenida() {
		System.out.println("Le damos la bienvenida al casino Deluxe!");
	}
}
