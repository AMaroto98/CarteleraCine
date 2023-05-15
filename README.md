# Práctica optativa

El objetivo de la siguiente práctica es consolidar los conocimientos adquiridos sobre streams en Java, además de ponerlos en práctica. Para ello, se propone realizar las siguientes actividades:

Desarrolla un programa que realice la lectura de un fichero txt que tenga el siguiente aspecto:

**The old man and the gun#2019#David Lowery#93#A lo largo de sus 80 años de vida, el ladrón de bancos Forrest Tucker ha logrado librarse 18 veces de ir a prisión. Ahora retirado, Tucker vive en un hogar de jubilados y ha encontrado en Jewel el amor de su vida. Pero cuando un día ve al detective John Hunt por televisión, el ex atracador siente la necesidad de dar un último golpe y demostrar que aún puede poner en jaque a la policía.#Robert Reford, Danny Glover#21:00{Capitana Marvel#2019#Ana Boden#128#La Tierra se encuentra atrapada en medio de una guerra galáctica entre dos razas alienígenas. Esto hará que Carol Danvers se convierta en una de las heroínas más poderosas del universo.#Jude Law, Samuel L.Jackson#22:00**

Como se puede observar, el fichero pertenece a la cartelera de un Cine. Nuestro objetivo es generar un fichero txt, teniendo en cuenta que existen dos tipos de marcas en el fichero origen, # que nos indica un campo nuevo y { que nos indica una nueva película. El fichero txt que se debe obtener tendrá el siguiente formato:

~~~
Cartelera de CineCIFFBMOLL

-----The old man and the gun------

Año: 2019

Director: David Lowery

Duración: 93 minutos

Sinopsis: A lo largo de sus 80 años de vida, el ladrón de bancos Forrest Tucker ha logrado librarse 18 veces de ir a prisión. Ahora retirado, Tucker vive en un hogar de jubilados y ha encontrado en Jewel el amor de su vida. Pero cuando un día ve al detective John Hunt por televisión, el ex atracador siente la necesidad de dar un último golpe y demostrar que aún puede poner en jaque a la policía.

Reparto: Robert Reford

Sesión: 21:00 horas

-----Capitana Marvel------

Año: 2019

Director: Ana Boden

Duración: 128 minutos

Sinopsis: La Tierra se encuentra atrapada en medio de una guerra galáctica entre dos razas alienígenas. Esto hará que Carol Danvers se convierta en una de las heroínas más poderosas del universo.

Reparto: Jude Law, Samuel L.Jackson

Sesión: 22:00 horas
~~~

## PARTE BÁSICA.

# El programa debe tener un menú, con las siguientes opciones:

1. Lectura y escritura del fichero de cartelera byte a byte (byte Streams).

2. Lectura y escritura de fichero de cartelera carácter a carácter (character Streams).

3. Lectura y escritura de fichero línea a línea con buffers (character Streams).

# Deberemos tener en cuenta que:

* En todas las opciones se debe solicitar al usuario la ruta del fichero de entrada y de salida.

* Además de controlar las excepciones (checked) que son obligatorias, debemos crear una excepción nueva para el caso en que la ruta del fichero de entrada/salida sea inválida (no esté informada) y generando una nueva excepción, llamada RutaInvalida. Esta excepción se capturará en el main, y una vez capturada llamaremos al método imprimirError e imprimiremos el mensaje de la excepción por consola. Este método se caracteriza por:

* Tener un constructor que recibe un mensaje que se utilizará para informar y personalizar que a posteriori se escribirá.

* Tener un método que permitirá escribir en un fichero de errores el mensaje con la siguiente información mensaje personalizado + timestamp +getStackTrace().

* Si hubiera más información en el fichero de errores, esta se debe mantener.

## PARTE AVANZADA.

Continuando con el ejercicio anterior, vamos a ampliar el menú para la lectura y escritura de objetos. Concretamente añadiremos la siguiente opción:

Tratamiento de objetos.

4. Esta opción 4, nos enviará a un nuevo menú con estas opciones:

* Lectura línea a línea y escritura con objetos (obteniendo ficheroSalObj).
* Lectura de objetos (leyendo ficheroSalObj) y escritura de objetos (obteniendo ficheroSalObj2).
* Lectura de objetos (leyendo ficheroSalObj2) y escritura por consola (comprobaremos por consola que nos ha escrito bien los objetos en los pasos anteriores).
* Volver al menú principal.

Para todas las opciones, se leerá por teclado la ruta de entrada y ruta de salida.

Tal y como hemos visto, necesitarás definir una clase con los campos adecuados para incorporar la información del fichero de cartelera. Analiza y diseña como debería ser la clase necesaria.

# Recomendaciones y orientaciones para la implementación

* Crear una clase llamada LecturaEscrituraStreams donde tendríamos los distintos métodos de lectura y escritura de ficheros: por ejemplo, pedirRuta, leerEscribirByteByte (escritura Byte a Byte), leerEscribirCarCar (ídem Carácter a Carácter), leerEscribirBuffer (ídem con Buffers), leerLineaEscribirObj (que leerá un fichero con BufferedReader y escribirá en otro con ObjectOutputStream) y leerObjEscribirCons (que lea un fichero con ObjectInputStream y lo mostrará por consola).

* Crear la clase Película que define como son los objetos "película" que serán leidos y escritos en ficheros. Esta digamos que es la parte que hemos preparado hasta ahora con los exámenes y simulacros.

* Crear la clase RutaInvalida que extiende de Excepcion que básicamente se utilizará cuando no se pueda acceder al fichero de entrada, debe tener constructores y un sistema de logs, es decir, guardar en un fichero de texto los errores que se han producido.

* Y una clase principal para probar toda la lógica, el menú, los ficheros y excepciones.