
package com.Kata.tennis.kataTennis.domain;

/**
 *
 * @author DELL
 */
public class Player {

    private Integer rang;
    private String name;

    public Player(Integer rang, String name) {
        this.rang = rang;
        this.name = name;

    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
