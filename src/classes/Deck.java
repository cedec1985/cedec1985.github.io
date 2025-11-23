package classes;

import java.awt.Image;
import java.util.*;
import javax.swing.*;

public class Deck {
    private List<Card> cards;
    private int currentCardIndex = 0;

    public Deck() {
        cards = new ArrayList<>();
        createDeck();
        shuffle();
    }

    private void createDeck() {
        String[] suits = {"Pique", "Cœur", "Carreau", "Trèfle"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11}; // valeur blackjack

        int imageIndex = 0;
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                String imagePath = "images/CARD" + String.format("%02d", imageIndex++) + ".jpg";
                ImageIcon icon = new ImageIcon(imagePath);
                Image scaled = icon.getImage().getScaledInstance(140, 120, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaled);
                cards.add(new Card(suit, ranks[i], values[i], icon));
            }
        }
    }

    public final void shuffle() {
        Collections.shuffle(cards);
        currentCardIndex = 0;
    }

    public Card drawCard() {
        if (currentCardIndex < cards.size()) {
            return cards.get(currentCardIndex++);
        } else {
            shuffle();
            return drawCard();
        }
    }
}
