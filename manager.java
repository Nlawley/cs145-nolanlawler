package cs145.labs.lab2;
import java.util.Scanner;

// this is the class that deals the cards. this is where we will program the blackjack game. ie: dealer gets two cards, player gets two cards, and if we add more players they will get two cards too. then we calculate who wins... blackjack rules and so on.

public class manager {
    public static void main(String[] args) {
        card dealer = new card();
        dealer.shuffle();
    
        System.out.println("\nHow manny cards would you like delt? (1-52)\n");
        Scanner scanner = new Scanner(System.in);
        int cardCount = scanner.nextInt();
        if(0 < cardCount){
          for (int i = 0; i < cardCount; i++) {
            int cardNumber = i + 1;
            System.out.printf("\nDealing card #%s: " + dealer.dealCard(),cardNumber);
          }
        }else{
          System.out.println("\nIllegal amount requested.");
          main(args);
        }
        scanner.close();
      }
}
