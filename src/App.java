import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcionPrincipal;
        int opcionAnidada;
        boolean salir = false;
        boolean atras = false;

        while (!salir) {

            ClearTerminal.clearTerminal();

            System.out.println("------------------ Menú ----------------");
            System.out.println("1. Lectura y escritura byte a byte");
            System.out.println("2. Lectura y escritura carácter a carácter");
            System.out.println("3. Lectura y escritura línea a línea");
            System.out.println("4. Lectura y escritura con objetos");
            System.out.println("5. Salir");
            System.out.println("------------------------------------------");

            try {

                System.out.print("Elige una de las opciones disponibles: ");
                opcionPrincipal = sc.nextInt();
                System.out.println();

            } catch (InputMismatchException e) {

                System.out.println("Opción invalida, debes ingresar un número");
                Sleep.pause(2000);
                sc.nextLine(); // limpiamos el scanner para evitar un loop infinito
                continue; // volvemos al inicio del loop
            }

            atras = false;

            switch (opcionPrincipal) {

                case 1:

                    LecturaEscrituraStreams.lecturaEscrituraByte();
                    break;

                case 2:

                    LecturaEscrituraStreams.lecturaEscrituraCaracter();
                    break;

                case 3:
                
                    LecturaEscrituraStreams.lecturaEscrituraBuffer();
                    break;

                case 4:

                    while (!atras) {

                        ClearTerminal.clearTerminal();

                        System.out.println("------------------ Menú ----------------");
                        System.out.println("1. Lectura y escritua con objetos");
                        System.out.println("2. Lectura y escritura de objetos");
                        System.out.println("3. Lectura y escritura por consola");
                        System.out.println("4. Atrás");
                        System.out.println("------------------------------------------");

                        try {

                            System.out.print("Elige una de las opciones disponibles: ");
                            opcionAnidada = sc.nextInt();
                            System.out.println();
            
                        } catch (InputMismatchException e) {
            
                            System.out.println("Opción invalida, debes ingresar un número");
                            Sleep.pause(2000);
                            sc.nextLine(); // limpiamos el scanner para evitar un loop infinito
                            continue; // volvemos al inicio del loop
                        }

                        switch (opcionAnidada) {

                            case 1:
                            
                                LecturaEscrituraStreams.leerLineaEscribirObj();
                                break;
                            
                            case 2:

                                break;

                            case 3:
                                
                                break;

                            case 4: 

                                atras = true;
                        
                            default:

                                break;
                        }
            
                        
                    }

                    break;

                case 5:

                    salir = true;
                    System.out.println("Hasta la vista mostro");
                    Sleep.pause(3000);
            
                default:

                    break;
            }
        }
        sc.close();
    }
}
