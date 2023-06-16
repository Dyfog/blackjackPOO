package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class JuegoBullseyeTest {

    @Test
    void crearCaballos() {
        ArrayList<Caballo> caballos = JuegoBullseye.crearCaballos();
        ArrayList<Caballo> caballosEsperados = new ArrayList<>();
        Caballo cab1 = new Caballo(1,"Rojo","Manuel");
        Caballo cab2 = new Caballo(2,"Azul","Juan");
        Caballo cab3 = new Caballo(3,"Verde","Carol");
        Caballo cab4 = new Caballo(4,"Amarillo","Alex");
        Caballo cab5 = new Caballo(5,"Rosado","Sofi");
        Caballo cab6 = new Caballo(6,"Negro","Sebastian");
        caballosEsperados.add(cab1);
        caballosEsperados.add(cab2);
        caballosEsperados.add(cab3);
        caballosEsperados.add(cab4);
        caballosEsperados.add(cab5);
        caballosEsperados.add(cab6);

        //asserts de las id´s de los caballos esperados con los obtenidos y en orden
        Assertions.assertEquals(caballosEsperados.get(0).getId(),caballos.get(0).getId());
        Assertions.assertEquals(caballosEsperados.get(1).getId(),caballos.get(1).getId());
        Assertions.assertEquals(caballosEsperados.get(2).getId(),caballos.get(2).getId());
        Assertions.assertEquals(caballosEsperados.get(3).getId(),caballos.get(3).getId());
        Assertions.assertEquals(caballosEsperados.get(4).getId(),caballos.get(4).getId());
        Assertions.assertEquals(caballosEsperados.get(5).getId(),caballos.get(5).getId());

        //asserts de los nombres de los caballos esperados con los obtenidos y en orden
        Assertions.assertEquals(caballosEsperados.get(0).getNombre(),caballos.get(0).getNombre());
        Assertions.assertEquals(caballosEsperados.get(1).getNombre(),caballos.get(1).getNombre());
        Assertions.assertEquals(caballosEsperados.get(2).getNombre(),caballos.get(2).getNombre());
        Assertions.assertEquals(caballosEsperados.get(3).getNombre(),caballos.get(3).getNombre());
        Assertions.assertEquals(caballosEsperados.get(4).getNombre(),caballos.get(4).getNombre());
        Assertions.assertEquals(caballosEsperados.get(5).getNombre(),caballos.get(5).getNombre());

        //asserts de los colores de los caballos esperados con los obtenidos y en orden
        Assertions.assertEquals(caballosEsperados.get(0).getColor(),caballos.get(0).getColor());
        Assertions.assertEquals(caballosEsperados.get(1).getColor(),caballos.get(1).getColor());
        Assertions.assertEquals(caballosEsperados.get(2).getColor(),caballos.get(2).getColor());
        Assertions.assertEquals(caballosEsperados.get(3).getColor(),caballos.get(3).getColor());
        Assertions.assertEquals(caballosEsperados.get(4).getColor(),caballos.get(4).getColor());
        Assertions.assertEquals(caballosEsperados.get(5).getColor(),caballos.get(5).getColor());

    }

    @Test
    void distribuirCaballos() {
        ArrayList<JugadorBullseye> jugadores = new ArrayList<>();

        //se crearon manualmente los jugadores porque en ese metodo se pide al usuario su nombre para crearlo como jugador
        JugadorBullseye jug1 = new JugadorBullseye("usuario");
        JugadorBullseye jug2 = new JugadorBullseye("jose");
        JugadorBullseye jug3 = new JugadorBullseye("agustin");
        JugadorBullseye jug4 = new JugadorBullseye("ignacio");
        JugadorBullseye jug5 = new JugadorBullseye("walter");
        JugadorBullseye jug6 = new JugadorBullseye("daniela");

        jugadores.add(jug1);
        jugadores.add(jug2);
        jugadores.add(jug3);
        jugadores.add(jug4);
        jugadores.add(jug5);
        jugadores.add(jug6);

        ArrayList<Caballo> caballos = JuegoBullseye.crearCaballos();
        JuegoBullseye.distribuirCaballos(jugadores,caballos);

        /*se supone que el metodo settea el atributo "IdCaballoElegido" de los jugadores, menos del primero
        que se establece previamente, por lo que el constructor deberia settearlo automaticamente en 0 por defecto
        al crearlo*/
        Assertions.assertEquals(jugadores.get(0).getIdCaballoElegido(),0);

        //ahora revisaremos que el mismo atributo mencionado anteriormente no sea 0 en los otros 5 jugadores
        Assertions.assertNotEquals(jugadores.get(1).getIdCaballoElegido(),0);
        Assertions.assertNotEquals(jugadores.get(2).getIdCaballoElegido(),0);
        Assertions.assertNotEquals(jugadores.get(3).getIdCaballoElegido(),0);
        Assertions.assertNotEquals(jugadores.get(4).getIdCaballoElegido(),0);
        Assertions.assertNotEquals(jugadores.get(5).getIdCaballoElegido(),0);

    }
}