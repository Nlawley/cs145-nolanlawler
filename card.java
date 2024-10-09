package cs145.labs.lab22;

public class card {
    String suit;
    String rank;
    int value;

    public card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    @Override //had this in to make it easier, dont really need it now but technically it is the safe this to have in, hellepd fix somanny problems.
    public String toString() {
        return rank + " of " + suit;
    }
}
