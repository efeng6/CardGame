public class Card
{
    private int point;
    private String suit;
    private String rank;

    public Card(String rank, String suit, int point) {
        this.point = point;
        this.suit = suit;
        this.rank = rank;
    }

    public int isHigher(Card other)
    {
        if (this.point > other.point)
        {
            return 1;
        }
        else if (this.point < other.point)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    public int getPoint() {
        return point;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public String toString()
    {
        return rank + " of " + suit;
    }

}
