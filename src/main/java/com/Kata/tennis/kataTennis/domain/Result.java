
package com.Kata.tennis.kataTennis.domain;

/**
 *
 * @author DELL
 */
public class Result {

    private int player1scoreSet;
    private int player2scoreSet;
    private String player1scoreGame;
    private String player2scoreGame;
    private int cpt1;
    private int cpt2;
    private Player playerWin;

    public Result() {
    }

    public Result(int score1, int score2, String game1, String game2, int cpt1, int cpt2) {
        this.player1scoreSet = score1;
        this.player2scoreSet = score2;
        this.player1scoreGame = game1;
        this.player2scoreGame= game2;
        this.cpt1 = cpt1;
        this.cpt2 = cpt2;
    }


    public int getPlayer1scoreSet() {
        return player1scoreSet;
    }

    public void setPlayer1scoreSet(int player1scoreSet) {
        this.player1scoreSet = player1scoreSet;
    }

    public int getPlayer2scoreSet() {
        return player2scoreSet;
    }

    public void setPlayer2scoreSet(int player2scoreSet) {
        this.player2scoreSet = player2scoreSet;
    }

    public String getPlayer1scoreGame() {
        return player1scoreGame;
    }

    public void setPlayer1scoreGame(String player1scoreGame) {
        this.player1scoreGame = player1scoreGame;
    }

    public String getPlayer2scoreGame() {
        return player2scoreGame;
    }

    public void setPlayer2scoreGame(String player2scoreGame) {
        this.player2scoreGame = player2scoreGame;
    }



    public Player getPlayerWin() {
        return playerWin;
    }

    public void setPlayerWin(Player playerWin) {
        this.playerWin = playerWin;
    }

    public int getCpt1() {
        return cpt1;
    }

    public void setCpt1(int cpt1) {
        this.cpt1 = cpt1;
    }

    public int getCpt2() {
        return cpt2;
    }

    public void setCpt2(int cpt2) {
        this.cpt2 = cpt2;
    }

}
