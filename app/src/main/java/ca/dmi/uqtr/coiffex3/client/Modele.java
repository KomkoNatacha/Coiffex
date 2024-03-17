package ca.dmi.uqtr.coiffex3.client;


public class Modele {

    private String nom;
    private String description;
    private int img;


    public Modele(String nom, String description, int img) {
        this.nom = nom;
        this.description = description;
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}