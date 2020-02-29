package game;

import materials.CoinState;

import java.util.List;

public class Rules {

  private static Rules uniqueInstance = null;

  private Rules() { }

  public static Rules getInstance() {
    if (uniqueInstance == null) { uniqueInstance = new Rules(); }
    return uniqueInstance;
  }

  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    // TODO: Votre code ici
    int nbVoulu = 3;
    int nbLance = states.size();
    int i = states.size() - 1;

    // Retourne faux si on n'a pas lancé le nombre voulu
    if (nbLance < nbVoulu) { return false; }

    // On regarde les trois derniers lancers
    while (i >= nbLance - nbVoulu) {
      if (!states.get(i).equals(CoinState.TAILS)) { break; }
      i--;
    }

    return (i == nbLance - nbVoulu - 1);
  }
}
