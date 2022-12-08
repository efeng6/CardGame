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
            for (String suit : suits) {
                deck.add(new Card(ranks[i], suit, values[i]));
                cardsLeft++;

            }
        }
    }

    public boolean isEmpty()
    {
        return cardsLeft == 0;
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

    /*
    Starting with last card in deck and moving forwards, replaces each card with random card in front of it
     */
    public void shuffle()
    {
        cardsLeft = deck.size();
        int random;
        for (int i = deck.size() - 1; i >= 0; i--)
        {
            random = (int)(Math.random() * i);
            Card temp = deck.get(random);
            deck.set(random, deck.get(i));
            deck.set(i,temp);

        }
    }




}
