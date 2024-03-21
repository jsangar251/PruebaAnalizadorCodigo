import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class HashCollisions {

  /*
   * Las colisiones de hash se producen cuando dos entradas diferentes producen el mismo valor hash. 
   * Esto puede crear una vulnerabilidad de seguridad en aplicaciones que dependen de funciones hash 
   * criptográficas, como cuando se aplica sobre contraseñas o para producir firmas digitales. Si una 
   * función hash criptográfica es vulnerable a las colisiones, los atacantes pueden crear dos entradas 
   * diferentes que produzcan el mismo valor hash, lo que podría provocar problemas de integridad y 
   * autenticidad de los datos.
   */

  public void md5HashFunction() throws NoSuchAlgorithmException {
    String input1 = "password1";
    String input2 = "password2";

    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] hash1 = md.digest(input1.getBytes());
    byte[] hash2 = md.digest(input2.getBytes());

    System.out.println("Hash1: " + new String(hash1));
    System.out.println("Hash2: " + new String(hash2));
  }

  /*
   * En este ejemplo, creamos dos entradas diferentes (input1 y input2) y calculamos sus valores hash MD5 
   * utilizando la clase MessageDigest de la API de seguridad de Java. Sin embargo, como MD5 es vulnerable 
   * a las colisiones, podría ocurrir que dos entradas diferentes produzcan el mismo valor hash, lo que 
   * significaría que una contraseña "password2" sería aceptada como si fuera "password1". 
   * Para solucionar esta vulnerabilidad, podemos pasar a utilizar una función hash más potente, como SHA-256 
   * o SHA-512, en lugar de MD5.
   */
  public void sha256HashFunction() throws NoSuchAlgorithmException {
    String input1 = "password1";
    String input2 = "password2";

    MessageDigest md = MessageDigest.getInstance("SHA-256");
    byte[] hash1 = md.digest(input1.getBytes());
    byte[] hash2 = md.digest(input2.getBytes());

    System.out.println("Hash1: " + new String(hash1));
    System.out.println("Hash2: " + new String(hash2));
  }
}
