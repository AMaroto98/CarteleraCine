import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaEscrituraStreams {

    static StringBuilder cartelera = new StringBuilder();

    public static void lecturaEscrituraByte() {


    }

    public static void lecturaEscrituraCaracter() {

        // Limpio la cartelera para reutilzarla
        cartelera.setLength(0);

        // Añado título de la cartelera
        cartelera.append(" Cartelera de Cine CIFFBMOLL:" + "\n" + "\n");

        try (FileReader entrada = new FileReader(Ruta.rutaEntrada())) {

            int contador = 0;
            int contadorAlmohadilla = 0;

            boolean año = false;
            boolean director = false;
            boolean duracion = false;
            boolean sinopsis = false;
            boolean reparto = false;
            boolean sesion = false;

            while (contador != -1) {

                contador = entrada.read();
                char letra = (char) contador;

                if (letra == '#') {
                    cartelera.append("\n" + "\n");
                    contadorAlmohadilla++;
                    continue;                 
                }

                if (letra == '{') {
                    cartelera.append("\n" + "\n");
                    contadorAlmohadilla = 0;
                    año = false;
                    director = false;
                    duracion = false;
                    sinopsis = false;
                    reparto = false;
                    sesion = false;
                    continue;                 
                }

                if (contadorAlmohadilla == 0 && letra != '#') {

                    cartelera.append(letra);
                }
               
                if (contadorAlmohadilla == 1 && letra != '#') {

                    if (!año) {
                        cartelera.append("Año: ");
                        año = true;
                    }

                    cartelera.append(letra);
                    
                }

                if (contadorAlmohadilla == 2 && letra != '#') {

                    if (!director) {
                        cartelera.append("Director: ");
                        director = true;
                    }

                    cartelera.append(letra);
                    
                }

                if (contadorAlmohadilla == 3 && letra != '#') {

                    if (!duracion) {
                        cartelera.append("Duración: ");
                        duracion = true;
                    }

                    cartelera.append(letra);
                    
                }

                if (contadorAlmohadilla == 4 && letra != '#') {

                    if (!sinopsis) {
                        cartelera.append("Sinopsis: ");
                        sinopsis = true;
                    }

                    cartelera.append(letra);
                }

                if (contadorAlmohadilla == 5 && letra != '#') {

                    if (!reparto) {
                        cartelera.append("Reparto: ");
                        reparto = true;
                    }

                    cartelera.append(letra);
                    
                }

                if (contadorAlmohadilla == 6 && letra != '#') {

                    if (!sesion) {
                        cartelera.append("Sesión: ");
                        sesion = true;
                    }

                    cartelera.append(letra);
                }
            }
            
        } catch (IOException e) {

            RutaInvalida.imprimirErrorLogs(e);
            System.out.println("Error LecturaEscrituraCaracter: " + e.getMessage());
        }

        // Escribir en un archivo
        try (FileWriter salida = new FileWriter(Ruta.rutaSalida())) {

            for (int i = 0; i < cartelera.length(); i++) {
                salida.write(cartelera.charAt(i));
            }

            salida.close();
            
        } catch (IOException e) {

            RutaInvalida.imprimirErrorLogs(e);
            System.out.println("Error LecturaEscrituraCaracter: " + e.getMessage());
        }

    }

    public static void lecturaEscrituraBuffer() {

        // Limpio la cartelera para reutilzarla
        cartelera.setLength(0);

        // Añado título de la cartelera
        cartelera.append(" Cartelera de Cine CIFFBMOLL:" + "\n" + "\n");

        // Lectura
        try (BufferedReader entrada = new BufferedReader(new FileReader(Ruta.rutaEntrada()))) {

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
                    cartelera.append("-----" + titulo + "-----" + "\n" + "\n");
                    cartelera.append("Año: " + año + "\n" + "\n");
                    cartelera.append("Director: " + director + "\n" + "\n");
                    cartelera.append("Duración: " + duracion + " minutos" + "\n" + "\n");
                    cartelera.append("Sinopsis: " + sinopsis + "\n" + "\n");
                    cartelera.append("Reparto: " + reparto + "\n" + "\n");
                    cartelera.append("Sesión: " + sesion + " horas" + "\n" + "\n");

                    // Limpio las variables que ya he añadido para poder reutilizarlas con las siguiente películas
                    for (int i = 0; i < partes.length; i++) {

                        partes[i] = "";
                        
                    } 
                }
            }

        } catch (IOException e) {

            RutaInvalida.imprimirErrorLogs(e);
            System.out.println("Error: " + e.getMessage());
        }

        // Escribo la cartelera en el archivo de salida
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Ruta.rutaSalida()))) {

            bw.write(cartelera.toString());

        } catch (IOException e) {

            RutaInvalida.imprimirErrorLogs(e);
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
