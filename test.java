/*For this lab, I encourage you to work in groups.  You are each expected to contribute to the successful completion of this lab.  When you are done, you will copy of the source code to  Canvas as a .java attachment.  Please do not submit a .class file.  Sorry, but I can't read machine code.  If you're having trouble with your code, send me a copy of your source code, along with screen shot of your compile errors messages.     

As before, you will be working with Visual Studio Code as your IDE.  I expect each member of your group to get comfortable using VCS throughout the quarter.  If you haven't already done so, please download VSC and start learning how to use the editor, debugger, and other features of the tool.

I also want each of you to get practice using Git/Git-Hub as a version control repository.  Practice creating files, branching, and falling back to previous versions as you work on your labs.  Git/Git-Hub is commonly used out in industry, as well as many colleges and universities.  You will need this for your final project.    

For lab 2, you'll be writing a card program using one-dimensional arrays.  For starters, use the  card program that I showed you earlier and create an interactive card program.  This could be Hearts, Black Jack, 21, etc.  I discourage you from doing Poker, since it's a little complicated.  This assignment will give you practice working with creating multiple classes. You are to write a program with three classes that work together: an object class (Card), a manager class (which keeps all the object methods), and the Test class (which houses the main method).  Try to keep main as small as possible.  */




//Went to kai for extra credit points. I went to him for all of the baseline 141 help to catch me up to speed since its been a year. Kai also explained the concepts of what I would need to do to get started on each class for the blackjack game project.

package cs145.labs.lab22;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    private static final int BLACKJACK = 21;
    private static final int DEALERMINSCORE = 17;

    private static int calculateScore(ArrayList<card> hand) {
        int score = 0;
        int aces = 0;//we use this int to track if aces are in play. If they are not there is no point in calculating them.

        for (card card : hand) {
            score += card.value;
            if (card.rank.equals("Ace")) {
                aces++;//if a ace is in play value goes up
            }
        }

        while (score > BLACKJACK && aces > 0) {
            score -= 10; // this is here to account for when aces are in play and need to be valued as 1. they start as 11 in the manager class. only can happen when the score is above 21 though.
            aces--;
        }

        return score;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            manager deck = new manager();
            ArrayList<card> playerHand = new ArrayList<>();
            ArrayList<card> dealerHand = new ArrayList<>();

            // this is the first round of dealing. 2 cards each, one not flipped over fo dealer.
            playerHand.add(deck.dealCard());
            playerHand.add(deck.dealCard());
            dealerHand.add(deck.dealCard());
            dealerHand.add(deck.dealCard());

            // this is a loop where the player takes a turn, hit / stand etc...
            while (true) {
                System.out.println("Your hand: " + playerHand + " (Score: " + calculateScore(playerHand) + ")");
                System.out.println("Dealer's hand: " + dealerHand.get(0) + " and [hidden]");
                System.out.print("Do you want to [h]it or [s]tand? ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("h")) {
                    playerHand.add(deck.dealCard());
                    if (calculateScore(playerHand) > BLACKJACK) {
                        System.out.println("Your hand: " + playerHand + " (Score: " + calculateScore(playerHand) + ")");
                        System.out.println("You busted! Dealer wins.");
                        break;
                    }
                } else if (choice.equalsIgnoreCase("s")) {
                    break;
                } else {
                    System.out.println("Invalid choice! Please enter 'h' or 's'.");
                }
            }

            //this is where the dealer playes his turn. ie hit untill score =<17
            while (calculateScore(dealerHand) < DEALERMINSCORE) {
                dealerHand.add(deck.dealCard());
            }

            // here is where we calculate the game score for each hand
            int playerScore = calculateScore(playerHand);
            int dealerScore = calculateScore(dealerHand);

            //print scores
            System.out.println("Your hand: " + playerHand + " (Score: " + playerScore + ")");
            System.out.println("Dealer's hand: " + dealerHand + " (Score: " + dealerScore + ")");

            //who won ?
            if (dealerScore > BLACKJACK) { 
                System.out.println("Dealer busted! You win!");
            } else if (playerScore > dealerScore) {
                System.out.println("You win!");
            } else if (playerScore < dealerScore) {
                System.out.println("Dealer wins!");
            } else {
                System.out.println("It's a tie!");
            }

           //loop exit/ restart
            System.out.print("Do you want to play again? [y/n]: ");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }// i have never tried this way of breaking a loop, but i dont see any problmes yet. is this a safe way to do so?
        }

        scanner.close();
    }//main loop end. always set to true. never ends untill 'break;' happends
}
