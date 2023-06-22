package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JuegoBullseye {
	public static void iniciar(){
		boolean seguirJugando = true;
		ArrayList<Caballo> caballos = crearCaballos();
		//aqui siempre el primer jugador sera el usuario
		ArrayList<JugadorBullseye> jugadores = generarJugadores();
		int apuesta = 0;
		System.out.println("Usted inicia el juego con 50000 pesos");
		while (jugadores.get(0).getDineroRestante()>0&&seguirJugando){
			ArrayList<Caballo> caballosRestantes = (ArrayList<Caballo>) caballos.clone();
			int eleccion = elegirCaballo(caballos);
			jugadores.get(0).setIdCaballoElegido(eleccion);
			caballosRestantes.remove(eleccion-1);
			apuesta = elegirApuesta(jugadores);
			distribuirCaballos(jugadores,caballosRestantes);
			int idGanador = (int)(Math.random()*6)+1;
			System.out.println("el ganador ha sido: "+caballos.get(idGanador-1).getNombre()
					+ ", de color " +caballos.get(idGanador-1).getColor()+ ", con el numero: "
					+caballos.get(idGanador-1).getId());
			if (jugadores.get(0).getIdCaballoElegido()==idGanador){
				System.out.println("Por lo tanto es usted el ganador");
				jugadores.get(0).setDineroRestante(jugadores.get(0).getDineroRestante()+apuesta);
			}else {
				System.out.println("Por lo que usted ha perdido");
			}
			seguirJugando = preguntarSeguirJugando();
			if(seguirJugando=false){
				System.out.println("usted se retira con "+jugadores.get(0).getDineroRestante()+" pesos");
			}

			if (jugadores.get(0).getDineroRestante()<=0) System.out.println("se ha quedado sin dinero restante por lo que no puede seguir jugando");


		}

	}
	public static String preguntarNombre(){
		Scanner in = new Scanner(System.in);
		System.out.println("ingrese su nombre para comenzar");
		return in.next();
	}
	public static ArrayList<Caballo> crearCaballos(){
		ArrayList<Caballo> caballos = new ArrayList<Caballo>();
		String[] colores = {"Rojo","Azul","Verde","Amarillo","Rosado","Negro"};
		String[] nombres = {"Manuel","Juan","Carol","Alex","Sofi","Sebastian"};
		for (int indice = 0; indice<6;indice++){
			//se usa el indice para acceder a los arreglos y el indice+1 para el id, ya que no inicia en 0 sino en 1.
			Caballo caballo = new Caballo(indice+1,colores[indice],nombres[indice]);
			caballos.add(caballo);
			caballo = null;
		}
		return caballos;
	}
	public static void listarCaballos(ArrayList<Caballo> caballos){
		for (int indice = 0; indice<6;indice++){
			System.out.println(indice+1+".-Nombre: "+caballos.get(indice).getNombre()+", id: "
					+caballos.get(indice).getId()+", Color: "+caballos.get(indice).getColor());
		}
	}
	public static int elegirCaballo(ArrayList<Caballo> caballos){
		Scanner in = new Scanner(System.in);
		System.out.println("elija entre alguno de los siguiente caballos ingresando su numero de id");
		listarCaballos(caballos);
		int eleccion = 1;
		boolean eleccionValida = false;

		while (!eleccionValida) {
			try {
				eleccion = in.nextInt();
				eleccionValida = Util.validarRango(eleccion, 1, 6);

				if (!eleccionValida) {
					System.out.println("Su número no está dentro de los rangos válidos, ingrese nuevamente");
				}
			} catch (InputMismatchException e) {
				System.out.println("El elemento ingresado no es válido, por favor ingrese nuevamente");
				in.nextLine();
			}
		}
		return eleccion;
	}


	public static ArrayList<JugadorBullseye> generarJugadores(){
		String[] nombresJugadores = {"jose","agustin","ignacio","walter","daniela"};
		ArrayList<JugadorBullseye> jugadores = new ArrayList<JugadorBullseye>();
		String nombre = preguntarNombre();
		JugadorBullseye jugador = new JugadorBullseye(nombre);
		jugadores.add(jugador);
		for (int indice = 0;indice<5;indice++) {
			JugadorBullseye jugadorNPC = new JugadorBullseye(nombresJugadores[indice]);
			jugadores.add(jugadorNPC);
			jugadorNPC = null;
		}
		return jugadores;
	}
	public static void distribuirCaballos(ArrayList<JugadorBullseye> jugadores, ArrayList<Caballo> caballosRestantes){
		Collections.shuffle(caballosRestantes);
		//con este for se hacen 5 ciclos, donde se toman a 5 de los jugadores, saltandose el primero que ya esta asignado
		for(int indice = 0;indice<5;indice++) {
			jugadores.get(indice+1).setIdCaballoElegido(caballosRestantes.get(0).getId());
			caballosRestantes.remove(0);
		}
	}

	public static int elegirApuesta(ArrayList<JugadorBullseye> jugadores){
		Scanner in = new Scanner(System.in);
		opcionesApuestas();
		int eleccion = 1;
		int valorApuesta = 0;
		boolean eleccionValida = false;

		while (!eleccionValida) {
			try {
				eleccion = in.nextInt();
				eleccionValida = Util.validarRango(eleccion, 1, 6);

				if (!eleccionValida) {
					System.out.println("Su número no está dentro de los rangos válidos, ingrese nuevamente");
				}
			} catch (InputMismatchException e) {
				System.out.println("El elemento ingresado no es válido, por favor ingrese nuevamente");
				in.nextLine();
			}
			switch (eleccion){
				case 1:
					jugadores.get(0).setDineroRestante(jugadores.get(0).getDineroRestante()-500);
					valorApuesta=500*2;
					break;
				case 2:
					jugadores.get(0).setDineroRestante(jugadores.get(0).getDineroRestante()-1000);

					valorApuesta=1000*3;
					break;
				case 3:
					jugadores.get(0).setDineroRestante(jugadores.get(0).getDineroRestante()-5000);
					valorApuesta=5000*4;
					break;
				case 4:
					jugadores.get(0).setDineroRestante(jugadores.get(0).getDineroRestante()-10000);
					valorApuesta=10000*5;
					break;
				case 5:
					jugadores.get(0).setDineroRestante(jugadores.get(0).getDineroRestante()-25000);
					valorApuesta=25000*7;
					break;
				case 6:
					jugadores.get(0).setDineroRestante(jugadores.get(0).getDineroRestante()-50000);
					valorApuesta=50000*10;
					break;
			}
		}
		return valorApuesta;
	}
	public static void opcionesApuestas(){
		System.out.println("Puede elegir entre los siguientes montos a apostar:");
		System.out.println("1.-$500: Si gana se aplica un multiplicador x2.");
		System.out.println("2.-$1000: Si gana se aplica un multiplicador x3.");
		System.out.println("3.-$5000: Si gana se aplica un multiplicador x4.");
		System.out.println("4.-$10000: Si gana se aplica un multiplicador x5");
		System.out.println("5.-$25000: Si gana se aplica un multiplicador x7.");
		System.out.println("6.-$50000: Si gana se aplica un multiplicador x10.");
	}


	public static boolean preguntarSeguirJugando(){
		Scanner in = new Scanner(System.in);
		int eleccion = 1;
		boolean seguirJugando = true;
		boolean eleccionValida = false;
		System.out.println("desea seguir jugando?");
		System.out.println("1.-Si");
		System.out.println("2.-No");
		while (!eleccionValida) {
			try {
				eleccion = in.nextInt();
				eleccionValida = Util.validarRango(eleccion, 1, 2);

				if (!eleccionValida) {
					System.out.println("Su número no está dentro de los rangos válidos, ingrese nuevamente");
				}
			} catch (InputMismatchException e) {
				System.out.println("El elemento ingresado no es válido, por favor ingrese nuevamente");
				in.nextLine();
			}
		}
		if (eleccion==2){seguirJugando=false;}
		return seguirJugando;
	}
}
