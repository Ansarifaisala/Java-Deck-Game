package assignment4;

/**
 * This Class has four methods which return suit, rank, value of card and Card
 * @author Ansari Mohammed Faisal - 000812671
 */
public class Cards {
    /**
     * suit this is suit of card
     * rank this is rak of the card
     * value this is value of card
     */
    private int suit, rank, value;

    /**
     * @param suit suit of the card
     * @param rank rank of the card
     */
    public Cards(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
        value = this.rank * this.suit;
    }

    /**
     * @return suit of the current card
     */
    public int getSuit() {
        return suit;
    }

    /**
     * @return value of the current card
     */
    public int getValue() {
        return value;
    }

    /**
     * @return rank of the current card
     */
    public int getRank() {
        return rank;
    }

    /**
     * @return returns current card in a string
     */
    @Override
    public String toString() {
        return "Card S" + suit + "R" + rank;
    }
}
