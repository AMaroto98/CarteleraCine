import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RutaInvalida extends Exception {

  public RutaInvalida(String mensaje) {
      super(mensaje);
  }

  public static void imprimirErrorLogs(Exception e) {

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String timestamp = now.format(formatter);

    try (FileWriter escribir = new FileWriter("/home/antonio/Documentos/Streams/logs/ErrorLogs.txt", true)) {

      escribir.write(timestamp + "\n" + e.getMessage() + "\n");
      
      for (StackTraceElement element : e.getStackTrace()) {

        escribir.write(element.toString() + "\n");

      }

      escribir.write("\n");

    } catch (IOException ex) {

      System.out.println("Error al escribir en el archivo: " + ex.getMessage());
    }
  }
}




