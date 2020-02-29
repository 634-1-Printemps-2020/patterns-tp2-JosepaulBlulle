package materials;

import java.util.Random;

public class Coin {

  private CoinState coinState;
  private static Coin uniqueInstance = null;

  private Coin() { }

  public static Coin getInstance() {
    if (uniqueInstance == null) { uniqueInstance = new Coin(); }
    return uniqueInstance;
  }

  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
    // TODO : Votre code ici
    int i = new Random().nextInt(CoinState.values().length);
    this.coinState = CoinState.values()[i];
  }

  public CoinState getState() {
    return coinState;
  }


}
