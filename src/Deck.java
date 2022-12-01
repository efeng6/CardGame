import java.util.ArrayList;
public class Deck
{
    public ArrayList<Card> deck = new ArrayList<Card>();
    public int cardsLeft;

    public Deck(String[] ranks, String[] suits, int[] values)
    {
        cardsLeft = 0;
        for (int i = 0; i < ranks.length; i++)
        {
            deck.add(new Card(ranks[i],suits[i],values[i]));
            cardsLeft++;
        }
    }

    public boolean isEmpty()
    {
        if (cardsLeft == 0)
        {
            return true;
        }
        return false;
    }

    public int getCardsLeft()
    {
        return cardsLeft;
    }

    public Card deal()
    {
        if (isEmpty())
        {
            return null;
        }
        cardsLeft--;
        return deck.get(cardsLeft);

    }



}
