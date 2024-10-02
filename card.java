package cs145.labs.lab2;
import java.util.ArrayList;
import java.util.Collections;

// this is the class the creates, stores, and shuffles the deck. we should not have much to do in this one quite yet.

public class card {
        private ArrayList<String> deck;
      
        public card() {
          this.deck = new ArrayList<>();
          String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
          String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
      
          for (String suit : suits) {
            for (String rank : ranks) {
              deck.add(rank + " of " + suit);
            }
          }
        }
      
        public void shuffle() {
          Collections.shuffle(deck);
        }
      
        public String dealCard() {
          if (deck.size() > 0) {
            return deck.remove(0);
          } else {
            return "No more cards in the deck!";
          }
        }
}
