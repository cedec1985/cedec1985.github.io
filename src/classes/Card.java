package classes;

import javax.swing.*;

public class Card {
    private final String suit;      // ♠, ♥, ♦, ♣
    private final String rank;      // 2, 3, ..., A
    private final int value;        // valeur num. pour le jeu
    private final ImageIcon image;  // image de la carte

    public Card(String suit, String rank, int value, ImageIcon image) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.image = image;
    }

    public String getSuit() { return suit; }
    public String getRank() { return rank; }
    public int getValue() { return value; }
    public ImageIcon getImage() { return image; }

    @Override
    public String toString() {
        return rank + " de " + suit;
    }
}
