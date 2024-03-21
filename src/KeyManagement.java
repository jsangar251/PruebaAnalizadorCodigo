import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class KeyManagement {
 
  /*
   * Gestión insegura de las claves: Si las claves criptográficas no se gestionan y protegen adecuadamente, 
   * los atacantes pueden ser capaces de robarlas o modificarlas, obteniendo potencialmente acceso a los datos cifrados
   */

  public void insecureKeyManagement() throws NoSuchAlgorithmException {
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    SecureRandom random = new SecureRandom();
    keyGen.initialize(2048, random);
    KeyPair keyPair = keyGen.generateKeyPair();
    PrivateKey privateKey = keyPair.getPrivate();
    PublicKey publicKey = keyPair.getPublic();

    System.out.println(privateKey + " " + publicKey);
  }

  /*
   * En este ejemplo, la aplicación está generando un par de claves pública-privada para su uso en el cifrado, pero la 
   * clave privada no está debidamente protegida o almacenada de forma segura. Un atacante podría robar la clave privada 
   * y utilizarla para descifrar datos confidenciales.
   * Una forma de solucionar esta vulnerabilidad es utilizar técnicas de gestión de claves adecuadas, como almacenar las 
   * claves en un almacén de claves seguro o utilizar módulos de seguridad de hardware (HSM) para proteger las claves. 
   */

  public void secureKeyManagement()
    throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException {
    KeyStore keyStore = KeyStore.getInstance("PKCS12");
    char[] password = "secret".toCharArray();
    keyStore.load(new FileInputStream("keystore.p12"), password);
    PrivateKey privateKey = (PrivateKey) keyStore.getKey("mykey", password);
    PublicKey publicKey = keyStore.getCertificate("mykey").getPublicKey();

    System.out.println(privateKey + " " + publicKey);
  }
  /*
   * En este ejemplo, estamos utilizando un almacén de claves PKCS12 para almacenar la clave privada, que está protegida por 
   * una contraseña.
   */
}
