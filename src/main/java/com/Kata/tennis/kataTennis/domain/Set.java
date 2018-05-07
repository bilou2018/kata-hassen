
package com.Kata.tennis.kataTennis.domain;

/**
 *
 * @author DELL
 */
public class Set {

    private Integer score1;
    private Integer score2;

    public Set(Integer score1, Integer score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    public Set() {
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

}
