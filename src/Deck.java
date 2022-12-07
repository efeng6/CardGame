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
            for (int j = 0; j < suits.length; j++) {
                deck.add(new Card(ranks[i], suits[j], values[i]));
                cardsLeft++;

            }
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

    public void shuffle()
    {
        cardsLeft = deck.size();
        int random;
        Card copy;
        for (int i = deck.size() - 1; i >= 0; i--)
        {
            random = (int)(Math.random() * i);
            Card temp = deck.get(random);
            deck.set(random, deck.get(i));
            deck.set(i,temp);

        }
    }


}
