import java.util.Scanner;
import java.io.File;

public class Ruta {

    static Scanner sc = new Scanner(System.in);

    public static String rutaEntrada() {

        String ruta = "";
    
        do {
    
            try {

                ruta = solicitarRutaEntrada();
                System.out.println("La ruta seleccionada es: " + ruta);

            } catch (RutaInvalida e) {

                RutaInvalida.imprimirErrorLogs(e);
                System.out.println(e.getMessage());

            }
    
        } while (ruta.isEmpty());

        return ruta;
    }

    public static String solicitarRutaEntrada() throws RutaInvalida {
    
        String rutaEntrada = "";
    
        System.out.print("Introduce la ruta de entrada del fichero: ");
        rutaEntrada = sc.nextLine();
    
        File archivo = new File(rutaEntrada);
    
        if (!archivo.exists() || !archivo.isFile()) {

            throw new RutaInvalida("La ruta proporcionada es inválida");
        }
    
        System.out.println("La ruta de entrada es válida");
        return rutaEntrada;
    }

    public static String rutaSalida() {

        String ruta = "";
    
        do {
    
            try {

                ruta = solicitarRutaSalida();
                System.out.println("La ruta seleccionada es: " + ruta);

            } catch (RutaInvalida e) {

                RutaInvalida.imprimirErrorLogs(e);
                System.out.println(e.getMessage());

            }
    
        } while (ruta.isEmpty());

        return ruta;
    }
    
    
    public static String solicitarRutaSalida() throws RutaInvalida {
    
        String rutaSalida = "";
        String nombreArchivo = "";
    
        System.out.print("Introduce la ruta de salida del fichero: ");
        rutaSalida = sc.nextLine();

        System.out.print("Introduce el nombre que tendrá el fichero: ");
        nombreArchivo = sc.nextLine();

        String rutaCompleta = rutaSalida + nombreArchivo;
    
        File archivo = new File(rutaCompleta);
    
        if (archivo.exists()) {
            
            throw new RutaInvalida("La ruta proporcionada es inválida");
        }
    
        System.out.println("La ruta de salida es válida");
        return rutaCompleta;
    }   
}