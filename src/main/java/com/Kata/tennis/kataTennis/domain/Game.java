package com.Kata.tennis.kataTennis.domain;

/**
 *
 * @author DELL
 */
public class Game {

    private int score1;
    private int score2;
    private Player player1;
    private Player player2;
    private Set set;
    private Result result;

    public Game(Player player1, Player player2, Set set, Result result) {
        this.player1 = player1;
        this.player2 = player2;
        this.set = set;
        this.result = result;
        this.score1 = 0;
        this.score2 = 0;
    }

    public Game() {

    }

    public Result addPoint(int playerRang) {
        if (result.getPlayerWin() != null) {
            return result;
        }
        if (result.getCpt1() == 0 && result.getCpt2() == 0) {
            if (player1.getRang() == playerRang) {
                score1 += 1;
            } else {
                score2 += 1;
            }
        }

        //En cas d'égalité 6-6, on doit ajouter un septième jeu décisif pour déterminer le joueur gagnant
        if ((result.getPlayer1scoreSet() == 6 && result.getPlayer2scoreSet() == 6)) {
            if (result.getCpt1() <= 7 && result.getCpt2() <= 7) {
                if (player1.getRang() == playerRang) {
                    result.setCpt1(result.getCpt1() + 1);
                } else {
                    result.setCpt2(result.getCpt2() + 1);
                }

                if (result.getCpt1() == 7) {
                    result.setPlayer1scoreSet(result.getPlayer1scoreSet() + 1);
                    result.setPlayerWin(player1);
                } else if (result.getCpt2() == 7) {
                    result.setPlayer2scoreSet(result.getPlayer2scoreSet() + 1);
                    result.setPlayerWin(player2);
                }
            }
            return result;
        }

        // Dans le cas ou l'avantage a été echoué,les deux joueurs sont de nouveau à égalité (40-40).  
        if (score1 == score2) {
            switch (score1) {
                case 0:
                    result.setPlayer1scoreGame(Score.Zero.getScore());
                    result.setPlayer2scoreGame(Score.Zero.getScore());
                    break;
                case 1:
                    result.setPlayer1scoreGame(Score.Fifteen.getScore());
                    result.setPlayer2scoreGame(Score.Fifteen.getScore());
                    break;
                case 2:
                    result.setPlayer1scoreGame(Score.Thirty.getScore());
                    result.setPlayer2scoreGame(Score.Thirty.getScore());
                    break;
                default:
                    result.setPlayer1scoreGame(Score.Forty.getScore());
                    result.setPlayer2scoreGame(Score.Forty.getScore());
                    break;

            }
        } else if (score1 >= 4 || score2 >= 4) {
            int minusResult = score1 - score2;
            if (minusResult == 1) {
                result.setPlayer1scoreGame(Score.AD.getScore());
                result.setPlayer2scoreGame(Score.Vide.getScore());
            } else if (minusResult == -1) {
                result.setPlayer1scoreGame(Score.Vide.getScore());
                result.setPlayer2scoreGame(Score.AD.getScore());
            } else if (minusResult >= 2) {
                //Joueur 1 gagne le jeux
                result.setPlayer1scoreSet(result.getPlayer1scoreSet() + 1);
                result.setPlayer1scoreGame(Score.Zero.getScore());
                result.setPlayer2scoreGame(Score.Zero.getScore());
                score1 = 0;
                score2 = 0;
            } else {
                //Joueur 2 gagne le jeux
                result.setPlayer2scoreSet(result.getPlayer2scoreSet() + 1);
                result.setPlayer1scoreGame(Score.Zero.getScore());
                result.setPlayer2scoreGame(Score.Zero.getScore());
                score1 = 0;
                score2 = 0;
            }
        } else {

            switch (score1) {
                case 0:
                    result.setPlayer1scoreGame(Score.Zero.getScore());
                    break;
                case 1:
                    result.setPlayer1scoreGame(Score.Fifteen.getScore());
                    break;
                case 2:
                    result.setPlayer1scoreGame(Score.Thirty.getScore());
                    break;
                case 3:
                    result.setPlayer1scoreGame(Score.Forty.getScore());
                    break;
            }
            switch (score2) {
                case 0:
                    result.setPlayer2scoreGame(Score.Zero.getScore());
                    break;
                case 1:
                    result.setPlayer2scoreGame(Score.Fifteen.getScore());
                    break;
                case 2:
                    result.setPlayer2scoreGame(Score.Thirty.getScore());
                    break;
                case 3:
                    result.setPlayer2scoreGame(Score.Forty.getScore());
                    break;
            }

        }
        //Déterminer le joueur gagnant
        if (((result.getPlayer1scoreSet() == 6 || result.getPlayer2scoreSet() == 6) && Math.abs(result.getPlayer1scoreSet() - result.getPlayer2scoreSet()) >= 2)
                || ((result.getPlayer1scoreSet() == 7 || result.getPlayer2scoreSet() == 7) && Math.abs(result.getPlayer1scoreSet() - result.getPlayer2scoreSet()) >= 2)) {
            if (result.getPlayer1scoreSet() > result.getPlayer2scoreSet()) {
                result.setPlayerWin(player1);
            } else {
                result.setPlayerWin(player2);
            }

        }

        return result;
    }

    public Result getResult() {
        return result;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

}
