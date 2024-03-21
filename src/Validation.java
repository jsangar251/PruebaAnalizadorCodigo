/*
 * Las vulnerabilidades de validación de entradas se producen cuando la entrada del usuario 
 * no se valida o "sanea" correctamente, lo que permite el envío de entradas maliciosas. 
 * Esto puede dar lugar a ataques como inyecciones SQL, secuencias de comandos en sitios 
 * cruzados (cross-site scripting o XSS), etc.
 */ 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    // Recuperamos los valores de los parámetros de la consulta pero no los validamos
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String message = request.getParameter("message");

    // Imprimimos en consola
    System.out.println(
      "Datos: " + name + ", " + email + ", " + phone + ", " + message
    );
  }
}
/*
 * Validar y "sanear" la entrada del usuario utilizando un marco como Hibernate Validator 
 * o Apache Commons Validator. Esto puede ayudar a evitar que se envíen entradas maliciosas y 
 * a garantizar que los datos se almacenen de forma coherente y segura.
 */
