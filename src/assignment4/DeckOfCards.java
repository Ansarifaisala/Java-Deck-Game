package assignment4;

import java.util.Arrays;

/**
 * This class methods to shuffle deck, deal cards, to return max and min value of deck and on deal, and report back size of deck
 * This Class also has Histogram method
 *
 * @author Ansari Mohammed Faisal - 000812671
 */
public class DeckOfCards {
    /**
     * Array of object of Cards class which represents Deck
     **/
    private Cards[] deck;
    /**
     * Object which is used to store temporary values
     **/
    Cards temp;
    /**
     * Value of cards
     **/
    private int value;
    /**
     * midpoint of deck
     **/
    private int midpoint;
    /**
     * max value of card
     **/
    private int max;
    /**
     * min value of card
     **/
    private int min;
    /**
     * array that stores value then it is sorted
     **/
    private int[] sort;


    /**
     * @param c1 Object of Cards class which is used to initialize  value
     */
    public DeckOfCards(Cards c1) {
        int suit = c1.getSuit();
        int rank = c1.getRank();
        value = c1.getValue();
        deck = new Cards[value];
        midpoint = (value / 2) - 1;
        sort = new int[value];
        int k = 0;
        for (int i = 1; i <= suit; i++) {           //Initializing Deck
            for (int j = 1; j <= rank; j++) {
                deck[k] = new Cards(i, j);
                k++;
            }
        }
    }

    /**
     * @return returns string that contains all cards
     */
    public String deck() {
        String cards = "";
        for (int i = 0; i < value; i++) {
            cards += deck[i].toString() + "\n";
        }
        return cards;
    }

    /**
     * Method to sort array that contains Values of all cards
     */
    public void arraySort() {
        for (int i = 0; i < deck.length; i++) {
            sort[i] = deck[i].getValue();
        }
        Arrays.sort(sort);
    }

    /**
     * @return returns max value of deck
     */
    public int getMax() {
        max = 0;
        for (int i = 0; i < value; i++) {
            if (max <= deck[i].getValue()) {
                max = deck[i].getValue();
            }
        }
        return max;
    }

    /**
     * @return returns smallest value of deck
     */
    public int getMin() {
        min = 0;
        for (int i = 0; i < value; i++) {
            if (min >= deck[i].getValue()) {
                min = deck[i].getValue();
            }
        }
        return min;
    }

    /**
     * @param  n number of cards to deal
     * @return returns max sum value of n cards
     */
    public int getMaxOnDeal(int n) {
        max = 0;
        for (int i = (sort.length - 1); i >= (sort.length - n); i--) {
            max += sort[i];
        }
        return max;
    }

    /**
     * @param n number of cards to deal
     * @return return lowest sum value of n card
     */
    public int getMinOnDeal(int n) {
        min = 0;
        for (int i = 0; i < n; i++) {
            min += sort[i];
        }
        return min;
    }

    /**
     * @return returns deck size
     */
    public int getSize() {
        return deck.length;
    }

    /**
     * @param n number of cards to deal
     * @return returns string that contains n cards
     */
    public String[] deal(int n) {
        String[] card_string = new String[n];
        for (int i = 0; i < n; i++) {
            card_string[i] = deck[i].toString();
        }
        return card_string;
    }

    /**
     * Method to shuffle deck
     */
    public void shuffle() {
        for (int i = 0; i <= midpoint; i++) {                   //running loop only till first half deck
            int card_number = (int) (Math.random() * ((((value - 1) - midpoint) + 1) + midpoint)); //selecting random number from second half to deck to swap cards
            temp = deck[i];
            deck[i] = deck[card_number];
            deck[card_number] = temp;
        }
    }

    /**
     * @param n number of cards to deal
     * @return return string that contains sum of n cards and how many tme they appeared
     */
    public String histogram(int n) {
        String histogram_string = "";
        arraySort();
        int[] score = new int[(getMaxOnDeal(n) - getMinOnDeal(n)) + 1];       //Deciding size of array that will hold the number of which sum appeared how many times
        for (int i = 0; i < score.length; i++) {                              //Initializing array every time to 0
            score[i] = 0;
        }
        for (int i = 0; i < 100000; i++) {                                    //Actual Histogram
            int sum = 0;
            shuffle();                                                        //Shuffling Deck
            for (int k = 0; k < n; k++) {                                     //Sum of n card values
                sum += deck[k].getValue();
            }
            for (int e = min; e <= max; e++) {                                //Incrementing the place where the Sum should appear
                if (e == sum) {                                               //Doing this so that sorting is not required
                    score[e - min]++;
                }
            }
        }
        for (int i = 0; i <= (max - min); i++) {                                //Storing values in String from a array to return it
            if (score[i] != 0) {
                histogram_string += (i + min) + ": " + score[i] + "\n";
            }
        }
        return histogram_string;
    }

    /**
     * @return return a String that asks for user choice
     */
    @Override
    public String toString() {
        return "Deck of " + value +
                " Cards: low = " + 1 +
                " high = " + value +
                " top = " + deck[0].toString() +
                "\n1=Shuffle, 2=Deal 1 Hand, 3=Deal 100000 Times, 4=Quit";
    }
}
