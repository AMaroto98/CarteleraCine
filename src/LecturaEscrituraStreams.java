import java.io.*;

public class LecturaEscrituraStreams {

    static StringBuilder cartelera = new StringBuilder();

    public static void lecturaEscrituraByte() {

        // Limpio la cartelera para reutilzarla
        cartelera.setLength(0);
        cartelera.append("Cartelera de Cine CIFFBMOLL:" + "\n" + "\n");

        try {

            FileInputStream entrada = new FileInputStream(Ruta.rutaEntrada());
            FileOutputStream salida = new FileOutputStream(Ruta.rutaSalida());
            
            int contador = 0;
            int contadorAlmohadilla = 0;

            String titulo = "";
            String año = "";
            String director = "";
            String duracion = "";
            String sinopsis = "";
            String reparto = "";
            String sesion = "";

            while (contador != -1) {

                contador = entrada.read();
                char letra = (char) contador;
                
                if (letra == '#') {
                    contadorAlmohadilla++;
                    continue;
                }

                if (contadorAlmohadilla == 0 && letra != '#') {
                    titulo += letra;
                }  

                if (contadorAlmohadilla == 1 && letra != '#') {
                    año += (char) letra;                    
                }

                if (contadorAlmohadilla == 2 && letra != '#') {
                    director += (char) letra;                    
                }

                if (contadorAlmohadilla == 3 && letra != '#') {
                    duracion += (char) letra;                    
                }

                if (contadorAlmohadilla == 4 && letra != '#') {
                    sinopsis += (char) letra;                    
                }

                if (contadorAlmohadilla == 5 && letra != '#') {
                    reparto += (char) letra;                    
                }

                if (contadorAlmohadilla == 6 && letra != '{') {
                    sesion += (char) letra;                    
                }

                if (letra == '{') {

                    contadorAlmohadilla = 0;

                    crearCartelera(cartelera, titulo, año, director, duracion, sinopsis, reparto, sesion);

                    titulo = "";
                    año = "";
                    director = "";
                    duracion = "";
                    sinopsis = "";
                    reparto = "";
                    sesion = "";
                    continue;
                }           
            }

            entrada.close();

            // Se vuelve a llamar a crearCartelera porque si es la última película ya no hay más { y o se pondría crear con la condición del if.
            crearCartelera(cartelera, titulo, año, director, duracion, sinopsis, reparto, sesion);
            salida.write(cartelera.toString().getBytes());
            salida.close();

        } catch (Exception e) {
            RutaInvalida.imprimirErrorLogs(e);
        }
    }

    public static void lecturaEscrituraCaracter() {

        // Limpio la cartelera para reutilzarla
        cartelera.setLength(0);
        cartelera.append("Cartelera de Cine CIFFBMOLL:" + "\n" + "\n");

        try {

            FileReader entrada = new FileReader(Ruta.rutaEntrada());
            FileWriter salida = new FileWriter(Ruta.rutaSalida());

            int contador = 0;
            int contadorAlmohadilla = 0;

            String titulo = "";
            String año = "";
            String director = "";
            String duracion = "";
            String sinopsis = "";
            String reparto = "";
            String sesion = "";

            while (contador != -1) {

                contador = entrada.read();
                char letra = (char) contador;

                if (letra == '#') {
                    contadorAlmohadilla++;
                    continue;                 
                }

                if (contadorAlmohadilla == 0 && letra != '#') {
                    titulo += letra;
                }
               
                if (contadorAlmohadilla == 1 && letra != '#') {
                    año += letra;
                }

                if (contadorAlmohadilla == 2 && letra != '#') {
                    director += letra;
                }

                if (contadorAlmohadilla == 3 && letra != '#') {
                    duracion += letra;
                }

                if (contadorAlmohadilla == 4 && letra != '#') {
                    sinopsis += letra;
                }

                if (contadorAlmohadilla == 5 && letra != '#') {
                    reparto += reparto;
                }

                if (contadorAlmohadilla == 6 && letra != '{') {
                    sesion += letra;
                }

                if (letra == '{') {

                    contadorAlmohadilla = 0;

                    crearCartelera(cartelera, titulo, año, director, duracion, sinopsis, reparto, sesion);

                    titulo = "";
                    año = "";
                    director = "";
                    duracion = "";
                    sinopsis = "";
                    reparto = "";
                    sesion = "";
                    continue;
                }  
            }

            entrada.close();

            // Se vuelve a llamar a crearCartelera para añadir la última película pues al ser la última en el texto no hay más { y no entraría en el if
            crearCartelera(cartelera, titulo, año, director, duracion, sinopsis, reparto, sesion);
            
            // Bucle para escribir todos los carácteres de la cartelera en un archivo de salida.
            for (int i = 0; i < cartelera.length(); i++) {
                salida.write(cartelera.charAt(i));
            }

            salida.close();
            
        } catch (IOException e) {
            RutaInvalida.imprimirErrorLogs(e);
        }
    }

    public static void lecturaEscrituraBuffer() {

        // Limpio la cartelera para reutilzarla
        cartelera.setLength(0);
        cartelera.append("Cartelera de Cine CIFFBMOLL:" + "\n" + "\n");

        try {

            BufferedReader entrada = new BufferedReader(new FileReader(Ruta.rutaEntrada()));
            BufferedWriter salida = new BufferedWriter(new FileWriter(Ruta.rutaSalida()));

            String linea;

            while ((linea = entrada.readLine()) != null) {

                // Hago un split para tener las películas por separado
                String[] peliculas = linea.split("\\{");

                // Recorro la array de peliculas
                for (String informacion : peliculas) {

                    // De cada película hago splits por # y setteo las líneas en las variables
                    String[] partes = informacion.split("#");

                    String titulo = partes[0];
                    String año = partes[1];
                    String director = partes[2];
                    String duracion = partes[3];
                    String sinopsis = partes[4];
                    String reparto = partes[5];
                    String sesion = partes[6];
                    
                    // Añado las variables a la cartelera
                    crearCartelera(cartelera, titulo, año, director, duracion, sinopsis, reparto, sesion);

                    // Limpio las variables que ya he añadido para poder reutilizarlas con las siguiente películas
                    for (int i = 0; i < partes.length; i++) {

                        partes[i] = "";
                        
                    } 
                }
            }

            entrada.close();

            // Se pinta la cartelera en el archivo de salida
            salida.write(cartelera.toString());
            salida.close();

        } catch (IOException e) {

            RutaInvalida.imprimirErrorLogs(e);
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void crearCartelera (StringBuilder cartelera, String titulo, String año, String director, String duracion, String sinopsis, String reparto, String sesion ) {

        cartelera.append("----- " + titulo + " -----" + "\n" + "\n");
        cartelera.append("Año: " + año + "\n" + "\n");
        cartelera.append("Director: " + director + "\n" + "\n");
        cartelera.append("Duración: " + duracion + " minutos" + "\n" + "\n");
        cartelera.append("Sinopsis: " + sinopsis + "\n" + "\n");
        cartelera.append("Reparto: " + reparto + "\n" + "\n");
        cartelera.append("Sesión: " + sesion + " horas" + "\n" + "\n");

    }
}
