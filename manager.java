package cs145.labs.lab22;

import java.util.ArrayList;
import java.util.Collections;

public class manager {
    private ArrayList<card> cards;

    public manager() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; //had to move this to our manager class, as to manipulate the arrays nicer.

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {//this for loop is how i got the value to match up to the array. i found it impossible to make the int arry work with the two sting array lists. works by finding the index with .length and adding to i till the value matches with the card. 
                int value = (i < 10) ? (i + 2) : (10); // 10 for face cards
                if (ranks[i].equals("Ace")) {
                    value = 11; // this starts out as 11 to solve the double value problem wiith aces
                }
                cards.add(new card(suit, ranks[i], value));
            }
        }
        Collections.shuffle(cards);
    }

    public card dealCard() {
        return cards.remove(cards.size() - 1);
    }
}
