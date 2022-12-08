import java.util.ArrayList;
public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int points;

    public Player(String name) {
        this.name = name;
        points = 0;
        hand = new ArrayList<Card>();
    }

    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
        points = 0;
        hand = new ArrayList<Card>();
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

    public boolean hasAce()
    {
        for(Card card : hand)
        {
            if(card.getRank().equals("A"))
            {
                return true;
            }
        }
        return false;
    }

}
