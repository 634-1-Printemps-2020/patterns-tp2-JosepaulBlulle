package utils;

public class Statistics {

  // Le nombre moyen de lancers pour gagner une partie
  private float averageToWin;

  // Le nombre le plus petit de lancers pour avoir gagné une partie
  private int fewerMovesToWin;
  // Le nombre le plus grand de lancers pour avoir gagné une partie
  private int mostMovesToWin;

  // Nombre total de lancers pour tous les joueurs
  private int totalNumberMoves;

  public Statistics(float averageToWin, int fewerMovesToWin, int mostMovesToWin, int totalNumberMoves) {
    this.averageToWin = averageToWin;
    this.fewerMovesToWin = fewerMovesToWin;
    this.mostMovesToWin = mostMovesToWin;
    this.totalNumberMoves = totalNumberMoves;
  }

  public float getAverageToWin() {
    return averageToWin;
  }

  public void setAverageToWin(float averageToWin) {
    this.averageToWin = averageToWin;
  }

  public int getFewerMovesToWin() {
    return fewerMovesToWin;
  }

  public void setFewerMovesToWin(int fewerMovesToWin) {
    this.fewerMovesToWin = fewerMovesToWin;
  }

  public int getMostMovesToWin() {
    return mostMovesToWin;
  }

  public void setMostMovesToWin(int mostMovesToWin) {
    this.mostMovesToWin = mostMovesToWin;
  }

  public int getTotalNumberMoves() {
    return totalNumberMoves;
  }

  public void setTotalNumberMoves(int totalNumberMoves) {
    this.totalNumberMoves = totalNumberMoves;
  }

  public String toString() {
    return "Moyenne pour gagner = " + averageToWin +
            "\nLe moins de lancer = " + fewerMovesToWin +
            "\nLe plus de lancer = " + mostMovesToWin +
            "\nTotal des lancers = " + totalNumberMoves;
  }
}
