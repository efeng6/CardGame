import java.util.ArrayList;
public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int points;

    public Player(String name) {
        this.name = name;
        points = 0;
    }

    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
        points = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void addCard(Card card)
    {
        hand.add(card);
        points += card.getPoint();
    }

    public String toString()
    {
        return name + " has " + points + " points." + name + "'s cards: " + hand;
    }

    public String toStringHand()
    {
        return name + "'s cards: " + hand;
    }

}
