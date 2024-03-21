import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/*
 * La inyección SQL es una vulnerabilidad por la que un atacante puede inyectar código SQL malicioso 
 * en una consulta, lo que potencialmente le permite acceder a los datos de la base de datos o modificarlos.
 */

public class SQLInjection {

  String db_URL = "localhost";
  String username = "usuario";
  String password = "contraseña";

  public void selectExample(String parameter) throws SQLException {
    Connection connection = DriverManager.getConnection(
      db_URL,
      username,
      password
    );

    // Consulta vulnerable 1
    String query = "SELECT * FROM USERS WHERE lastname = " + parameter;
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(query);
    printResult(result);

    // Consulta vulnerable 2
    String sql =
      "SELECT * FROM users WHERE username='" +
      username +
      "' AND password='" +
      password +
      "'";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    printResult(rs);
  }

  /*
   * La inyección SQL puede mitigarse utilizando sentencias preparadas (PreparedStatement), 
   * que impiden que el atacante pueda modificar la consulta.
   */

  public void prepStatmentExample(String parameter) throws SQLException {
    Connection connection = DriverManager.getConnection(
      db_URL,
      username,
      password
    );

    // Consulta vulnerable 1 corregida
    String query = "SELECT * FROM USERS WHERE lastname = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, parameter);
    System.out.println(statement);
    ResultSet result = statement.executeQuery();
    printResult(result);

    // Consulta vulnerable 2 corregida
    String sql = "SELECT * FROM users WHERE username=? AND password=?";
    PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setString(1, username);
    pstmt.setString(2, password);
    ResultSet rs = pstmt.executeQuery();
    printResult(rs);
  }

  public void printResult(ResultSet result) {
    System.out.println(result);
  }
}
