import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/*
 * Las vulnerabilidades en la gestión de sesiones se producen cuando los datos de sesión 
 * no están debidamente protegidos o cuando las sesiones no se gestionan correctamente. 
 * Esto puede dar lugar a ataques como el secuestro de sesión o la fijación de sesión.
 */
public class SessionManagement extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    HttpSession session = request.getSession();
    String username = (String) session.getAttribute("username");

    // Imprimimos en consola
    System.out.println("Datos: " + username);
  }
}
/*
 * Utiliza técnicas de gestión de sesiones seguras, como identificadores de sesión aleatorios, 
 * tiempos de espera de sesión y configuraciones de cookies seguras. También puede utilizar un 
 * marco como Spring Session para proporcionar funciones adicionales como la gestión de sesiones 
 * distribuidas y opciones de seguridad avanzadas.
 */