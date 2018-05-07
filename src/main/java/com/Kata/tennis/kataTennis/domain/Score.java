/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Kata.tennis.kataTennis.domain;

/**
 *
 * @author DELL
 */
public enum Score {
     //Objets directement construits
    Zero("0"),
    Fifteen("15"),
    Thirty("30"),
    Forty("40"),
    AD("AD"),
    Vide("");
    private String score;

    //Constructeur
    Score(String categ) {
        this.score = categ;
    }

    public String getScore() {
        return score;
    }
   
  
}
