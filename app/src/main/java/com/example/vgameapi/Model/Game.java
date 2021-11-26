package com.example.vgameapi.Model;

public class Game {

    public String nom;
    public String desc;

    public Game(String nom, String desc) {
        this.nom = nom;
        this.desc = desc;
    }

    public String getNom() {
        return nom;
    }
    public String getDesc() { return desc; }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDesc(String desc) { this.desc = desc; }
}
