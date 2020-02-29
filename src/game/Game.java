package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules = Rules.getInstance();
    private Coin coin = Coin.getInstance();
    private Map<Player, List<CoinState>> history;

    public Game() {
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
        // TODO: Votre code ici
        history.putIfAbsent(player, new ArrayList<>());
    }

    /**
     * Faire jouer tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
        // TODO: Votre code ici
        Set<Player> noWinPlayers = new HashSet<>(history.keySet());
        Iterator<Player> iter;
        Player player;
        
        while (noWinPlayers.size() != 0) {
            iter = noWinPlayers.iterator();

            // Pour chaque joueur n'ayant pas gagné
            while (iter.hasNext()) {
                player = iter.next();

                // On lance la pièce et on l'ajoute dans l'historique
                player.play(coin);
                history.get(player).add(coin.getState());

                // S'il gagne on l'enlève des joueurs restants
                if (rules.checkWin(history.get(player))) {
                    iter.remove();
                }
            }
        }

    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
        // TODO: Votre code ici
        float averageToWin;
        int fewerMovesToWin = 0;
        int mostMovesToWin = 0;
        int totalNumberMoves = 0;

        for (List<CoinState> coinStates: history.values()) {
            int nbLance = coinStates.size();

            if (fewerMovesToWin == 0 || fewerMovesToWin > nbLance) { fewerMovesToWin = nbLance; }
            if (mostMovesToWin == 0 || mostMovesToWin < nbLance) { mostMovesToWin = nbLance; }
            totalNumberMoves += nbLance;
        }
        averageToWin = (float) totalNumberMoves / history.keySet().size();

        return new Statistics(averageToWin, fewerMovesToWin, mostMovesToWin, totalNumberMoves);
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      // TODO: Votre code ici
      return history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      // TODO: Votre code ici
      return history.get(player);
    }

}
