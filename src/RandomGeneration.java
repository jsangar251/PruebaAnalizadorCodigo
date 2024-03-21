import java.security.SecureRandom;

public class RandomGeneration {

  /*
   * Generación deficiente de números aleatorios: Los algoritmos criptográficos a menudo se
   * basan en números aleatorios para generar claves seguras y vectores de inicialización.
   * Si estos números aleatorios no son realmente aleatorios, pueden ser predecibles y vulnerables
   * a los ataques.
   */

  public void poorRandomNumberGeneration() {
    SecureRandom random = new SecureRandom();
    byte[] key = new byte[16];
    random.nextBytes(key);
  }

  /*
   * En el ejemplo anterior, la aplicación está utilizando un objeto SecureRandom para generar una clave de
   * 16 bytes, pero el objeto SecureRandom no está correctamente sembrado con datos aleatorios. Esto
   * podría hacer que la clave fuera predecible y vulnerable a los ataques.
   * Una forma de solucionar esta vulnerabilidad es sembrar correctamente el objeto SecureRandom con
   * datos aleatorios, por ejemplo, utilizando un generador de números aleatorios de hardware o recopilando
   * entropía de la entrada del usuario o de los eventos del sistema.
   */

  public void notFixedRandomNumberGeneration() {
    SecureRandom random = new SecureRandom();
    byte[] seed = new byte[32];
    random.nextBytes(seed);
    random.setSeed(seed);
    byte[] key = new byte[16];
    random.nextBytes(key);
  }
  /*
   * En este ejemplo anterior, la aplicación no logra paliar del todo la vulnerabilidad antes descrita porque vuelve a sembrar
   * el objeto 'random' con una semilla predecible y, por tanto, la clave generada después sería también predecible.
   */

  public void betterRandomNumberGeneration() {
    SecureRandom random = new SecureRandom();
    random.reseed();
    byte[] key = new byte[16];
    random.nextBytes(key);
  }
  /*
   * En este último ejemplo, la aplicación vuelve a sembrar el generador de números aleatorios (RNG) con entropía de entrada
   * leída desde su fuente de entropía. Por tanto, la semilla no debe ser predecible y la clave generada después sería también impredecible.
   */
}
