import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {

            System.out.println("------------------ Menú ----------------");
            System.out.println("1. Lectura y escritura byte a byte");
            System.out.println("2. Lectura y escritura carácter a carácter");
            System.out.println("3. Lectura y escritura línea a línea");
            System.out.println("4. Salir");
            System.out.println("------------------------------------------");

            System.out.print("Introduce una de las opciones disponibles: ");
            int opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {

                case 1:

                    Ruta.rutaEntrada();
                    break;

                case 2:

                    Ruta.rutaSalida();
                    break;

                case 3:

                    break;

                case 4:
                    salir = true;
            
                default:
                    break;
            }

            
        }
        sc.close();
    }
    
}
