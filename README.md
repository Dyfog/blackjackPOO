# blackjackPOO
 
### Alumno: Mario Laurie Aravena

**Analisis:**

Para el proyecto de blackjack se necesitarian 4 clases de acuerdo al contexto problema, las cuales serian:

**Main:**

Esta se usaría simplemente para lanzar el programa a travez de la clase "Juego" y tal vez algun texto por consola para el usuario.

**Juego:**

En esta clase se instanciarian el/los objeto/s "jugador", y un arreglo de objetos "carta" que seria la baraja a usar, ademas de todos los metodos correspondientes al juego y determinar el ganador

**Jugador:**

Esta clase se usaria principalmente para ordenar atributos correspondientes al mismo, como un arreglo de objetos "carta" llamado "mano" y un entero referenciando sus puntos

**Carta:**

Esta corresponderia a la clase usada para crear objetos con los atributos de "pinta", "indice" y "valor", para asi poder ingresarlos en solo un arreglo de cartas, ya sea en la baraja o en la mano del jugador, y asi acceder a los distintos parametros de la misma de manera mas facil.


Con todo esto explicado podemos concluir que :

-La clase "Main" dependera/usara a la clase "Juego" para lanzar el mismo

-La clase "Juego" dependera/usara a las clases "Jugador" y "Carta" para instanciar, conocer y modificar sus valores (este ultimo solo en el caso del jugador) para llevar a cabo el juego
