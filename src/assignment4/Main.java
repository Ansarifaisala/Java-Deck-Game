package assignment4;

import java.util.Scanner;

/**
 * Main takes input from user and validates it, if it is not correct it asks user to re-enter input
 * Once main has proper input it creates object of Cards class while passing both values Rank and Suit
 * And then it crates object for DeckOfCards class passing object of Cards class as argument
 * And then it Calls different function based on user input such as shuffle, deal and histogram
 * User can exit the program by pressing 4
 *
 *  @author Ansari Mohammed Faisal - 000812671
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
		 * suit for the number of suits
		 * rank for number of ranks
		 * n is for user input of number of cards
		 * i is used in for loops
		 * choice is for the user inout of what he wants Shuffle, Deal or Deal 100000 times or Exit Program
		 **/
        int suit = 1, rank = 1, n, i, choice;
		/**
		 * su for user input of suits as user can also input alphabets
		 * r for user input of ranks as user can also input alphabets
		 **/
        String su, r;
		/**correct is flag variable for correct input**/
        boolean correct = false;
		/**sc for storing the string array that is returned by deal()**/
        String[] sc;
        Scanner s = new Scanner(System.in);
        System.out.println("How many Suits? Please Do Not Enter 0:");
        su = s.nextLine();
        System.out.println("How many Ranks? Please Do Not Enter 0:");
        r = s.nextLine();
		/**Validating inputs and taking input again and again if they are incorrect**/
        while (!correct) {
            if ((su.matches(".*[a-zA-Z]+.*")) == false			//Checking if the the string has alphabet
                    && (r.matches(".*[a-zA-Z]+.*")) == false
                    && (Integer.parseInt(su)) > 0						//Checking if the entered string is not a zero
                    && (Integer.parseInt(r)) > 0) {
                suit = Integer.parseInt(su);							//Converting String to int
                rank = Integer.parseInt(r);								//Converting String to int
                correct = true;											//Setting flag variable to true so it exits from while loop
            } else {
                System.out.println("Wrong Input:");

                System.out.println("How many Suits?");					//Taking inputs again
                su = s.nextLine();

                System.out.println("How many Ranks?");
                r = s.nextLine();
            }
        }
        Cards c1 = new Cards(suit, rank);
        DeckOfCards deck = new DeckOfCards(c1);
        System.out.println(deck.deck());									//Printing Cards in Deck
        System.out.println(deck.toString());								//Printing Choices and taking input
        choice = s.nextInt();
        while (choice != 4) {											//Checking User input and calling function based on that
            if (choice == 1) {
                deck.shuffle();											//Shuffling Deck
                System.out.println(deck.toString());
                choice = s.nextInt();
            } else if (choice == 2) {
                System.out.println("How many Cards do u want?");
                n = s.nextInt();
                sc = new String[n];
                sc = deck.deal(n);										//Dealing Cards
                for (i = 0; i < n; i++) {
                    System.out.println(sc[i]);
                }
                System.out.println(deck.toString());
                choice = s.nextInt();
            } else if (choice == 3) {
                System.out.println("How many Cards do u want?");
                n = s.nextInt();
                System.out.println(deck.histogram(n));					//Calling histogram
                System.out.println(deck.toString());
                choice = s.nextInt();
            } else {
                System.out.println("Wrong Input: Please Enter from the choices above");
                System.out.println(deck.toString());
                choice = s.nextInt();
            }
        }
        System.out.println("BYE!!");
    }


}