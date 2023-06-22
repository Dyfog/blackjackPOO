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


***Contenido ayudantia 3:***

-Dentro del nuevo diagrama usado, se añadieron 5 clases, una clase para seleccionar el juego a iniciar (SelectorJuego), una clase donde se maneja el juego Bullseye como tal (JuegoBullseye), para la cual se necesitarian 2 clases mas, una para el jugador especifico para Bullseye y otra clase de Caballos, ademas se añadio una clase Util para el validador que estoy usando, pero que podrian crecer en numero en el futuro.

-Hasta la ayudantia anterior (2) trabaje en la branch main por equivocacion y no correccion mia, ahora creé una branch de desarrollo con el mismo nombre, cuando finalice el codigo haré un merge de la brach de desarrollo a las main.

-Ya que se crearon clases nuevas que tenian nombres que podrian resultar confusos ahora que se ingresarian clases nuevas, modifique los nombres de la clase del juego de blackjack y su respectiva clase de jugador para que estas aludieran especificamente a que eran para el juego blackjack 

-las relaciones entre todas estas nuevas clases serian de dependencia, ya que en ningun momento uso objetos de una clase como parametros de otra (o otras formas similares), tambien añadir que aunque vi una pequeña posibilidad de usar herencia en los jugadores de blackjack y bullseye, no concluí que uno fuera "un tipo de" respecto a la otra clase, y los atributos correspondientes no tenian similitudes entre si. por lo que no hice uso de herencia en este.

-Luego de hacer todo el codigo aparecieron bastantes metodos que no tenia considerando en un inicio y tambien se añadio un atributo a la clase del jugador de bullseye, para asi poder mejorar la interaccion con el juego, por lo que si bien hacer el diagrama y generar codigo ayudo y acelero mucho el desarrollo, pudo ser mejor.


***Contenido ayudantia 4:***

-En esta nueva ayudantia se implementaron 3 clases más, 1 ventana principal y 1 ventana por cada juego (2), pero se elimino 1 clase que era el selector de juego, ya que esta operaba como entrada/salida de las opciones de juego preeliminarmente

-se hicieron nuevos metodos en la clase del juego de bulleye ya que como muchos de los metodos contenian muchos prints o elecciones, se prefirio hacer metodos nuevos para las ventanas, los cuales hacer mayor uso de return de Strings e ints que de prints para el usuario.

-tambien se hicieron los botones para volver y se usaron listas de elecciones para asi usar su indice de eleccion y ocuparlos como datos normales, tambien se valido que para que el boton funcionara, tenia que haber elegido en todas las listas un valor, para que funcionara correctamnte.
