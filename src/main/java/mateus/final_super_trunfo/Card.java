package mateus.final_super_trunfo;

import javafx.scene.image.Image;

public class Card {
    private String nome;
    private int atck;
    private int def;
    private int mag;
    private Image image;
    public Card(String nome, int atck, int def, int mag, Image image) {
        this.nome = nome;
        this.atck = atck;
        this.def = def;
        this.mag = mag;
        this.image = image;
        Game.addCard(this);
    }
    public String getNome() {
        return nome;
    }

    public int getAtck() {
        return atck;
    }

    public int getDef() {
        return def;
    }

    public int getMag() {
        return mag;
    }

    public Image getImage() {
        return image;
    }
}
