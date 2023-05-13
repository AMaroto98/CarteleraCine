import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaEscrituraStreams {

    static StringBuilder cartelera = new StringBuilder();

    public static void lecturaEscrituraByte() {}

    public static void lecturaEscrituraCaracter() {

        try (FileReader entrada = new FileReader(Ruta.rutaEntrada())) {

            // Para limpiar la cartelera para reutilzarla
            cartelera.setLength(0);

            int contador = 0;
            int contadorAlmohadilla = 0;

            boolean año = false;
            boolean director = false;
            boolean duracion = false;
            boolean sinopsis = false;
            boolean reparto = false;
            boolean sesion = false;

            cartelera.append("Cartelera de Cine CIFFBMOLL" + "\n" + "\n");

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

            System.out.println("Error LecturaEscrituraCaracter: " + e.getMessage());
        }

        // Escribir en un archivo
        try (FileWriter salida = new FileWriter(Ruta.rutaSalida())) {

            for (int i = 0; i < cartelera.length(); i++) {
                salida.write(cartelera.charAt(i));
            }

            salida.close();
            
        } catch (IOException e) {

            System.out.println("Error LecturaEscrituraCaracter: " + e.getMessage());
        }

    }

    public static void lecturaEscrituraBuffer() {

        // Lectura
        try (BufferedReader entrada = new BufferedReader(new FileReader("file.txt"))) {

            String linea;

            while ((linea = entrada.readLine()) != null) {
                String[] partes = linea.split("#");

                // Extraer la información de la película
                String titulo = partes[0];
                String año = partes[1];
                String director = partes[2];
                String duracion = partes[3];
                String sinopsis = partes[4];
                String reparto = partes[5];
                String sesion = partes[6];

                // Imprimir la información en el formato deseado
                System.out.println("-----" + titulo + "-----");
                System.out.println("Año: " + año);
                System.out.println("Director: " + director);
                System.out.println("Duración: " + duracion + " minutos");
                System.out.println("Sinopsis: " + sinopsis);
                System.out.println("Reparto: " + reparto);
                System.out.println("Sesión: " + sesion + " horas \n");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
