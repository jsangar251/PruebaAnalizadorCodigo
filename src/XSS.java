import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;
 
/*
 * XSS es una vulnerabilidad por la que un atacante puede inyectar código malicioso 
 * (normalmente JavaScript) en una página web, lo que podría permitirle robar datos 
 * confidenciales o realizar acciones en nombre del usuario. Esta vulnerabilidad puede 
 * mitigarse "saneando" la entrada del usuario y codificando la salida para evitar la 
 * ejecución de scripts (guiones) maliciosos.
 */ 

public class XSS extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    // Recuperar el valor del parámetro de consulta "username" 
    String username = request.getParameter("username");
    // Establecer el tipo MIME del mensaje de respuesta
    response.setContentType("text/html;charset=UTF-8");
    // Asignar un "escritor de salida" para escribir el mensaje de respuesta en el socket de red.
    PrintWriter out = response.getWriter();

    // Escribe el mensaje de respuesta, en una página HTML
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html><head>");
      out.println(
        "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>"
      );
      out.println("<title>Hello, World</title></head>");
      out.println("<body>");

      // Código vulnerable
      out.println("<h1>Welcome " + username + "</h1>");

      // Código corregido
      out.println(
        "<h1>Welcome " + StringEscapeUtils.escapeHtml4(username) + "</h1>"
      );

      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close(); // Cerrar siempre el escritor de salida
    }
  }
}
