# blackjackPOO
 
### Alumno: Mario Laurie Aravena

***Analisis:***

Para el proyecto de blackjack se necesitarian 4 clases de acuerdo al contexto problema, las cuales serian:

**Main:**

Esta se usaría simplemente para lanzar el programa a travez de la clase "Juego" y tal vez algun texto por consola para el usuario.

**Juego:**

En esta clase se instanciarian el/los objeto/s "jugador", y un arreglo de objetos "carta" que seria la baraja a usar, ademas de todos los metodos correspondientes al juego y determinar el ganador

**Jugador:**

Esta clase se usaria principalmente para ordenar atributos correspondientes al mismo, como un arreglo de objetos "carta" llamado "mano" y un entero referenciando sus puntos

**Carta:**

Esta corresponderia a la clase usada para crear objetos con los atributos de "pinta", "indice" y "valor", para asi poder ingresarlos en solo un arreglo de cartas, ya sea en la baraja o en la mano del jugador, y asi acceder a los distintos parametros de la misma de manera mas facil.

***Relaciones:***

Con todo esto explicado podemos concluir que :

-La clase "Main" dependera/usara a la clase "Juego" para lanzar el mismo

-La clase "Juego" dependera/usara a las clases "Jugador" y "Carta" para instanciar, conocer y modificar sus valores (este ultimo solo en el caso del jugador) para llevar a cabo el juego

-La clase "Jugador" tendra una asociacion unidireccional hacia "Carta", ya que el jugador tiene como atributo una lista de cartas


***Contenido ayudantia 2:***

Ya que el problema era reltaivamente simple, y el diagrama fue bien planteado desde un inicio, el modelo de clases y sus relaciones realmente no cambiaron, ademas comentar que como en primera ayudantia pensé que serian envios separados y no todo en un solo repositorio, subí esto en la rama main, para asi conservar el registro de los commits, tambien el codigo se hizo todo junto en intelIJ y luego se subío entero, pero la solucion planteada funciona sin problemas.
