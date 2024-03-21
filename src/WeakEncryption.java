import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
 
public class WeakEncryption {

  /*
   * El uso de algoritmos de cifrado débiles puede facilitar a los atacantes la tarea de descifrar 
   * los datos cifrados, lo que podría darles acceso a información confidencial.
   */
  public void weakEncryption()
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    SecretKeySpec key = new SecretKeySpec("password".getBytes(), "DES");
    Cipher cipher = Cipher.getInstance("DES");
    cipher.init(Cipher.ENCRYPT_MODE, key);
    byte[] encrypted = cipher.doFinal("secret data".getBytes());
    System.out.println(encrypted);
  }

  /*
   * En este ejemplo, la aplicación utiliza el algoritmo de cifrado DES, que se considera débil y 
   * vulnerable a los ataques. Un atacante podría descifrar los datos cifrados mediante un ataque de 
   * fuerza bruta o de diccionario. Una forma de solucionar esta vulnerabilidad es utilizar algoritmos 
   * de cifrado más potentes, como AES o RSA.
   */
  public void strongerEncryption()
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    SecretKeySpec key = new SecretKeySpec("password".getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, key);
    byte[] encrypted = cipher.doFinal("secret data".getBytes());
    System.out.println(encrypted);
  }
}
