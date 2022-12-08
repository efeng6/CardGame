import java.util.Scanner;

public class Game
{
    private String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
    private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    private Deck deck = new Deck(ranks, suits, values);
    private Player player;
    private Player dealer = new Player("Dealer");
    private Scanner s = new Scanner(System.in);
    private String hitorstand;


    public static void main(String[] args)
    {

        Game g = new Game();
        g.printInstructions();
        g.dealStartingHand();
        g.playGame();
        g.incrementDealer();
        g.endSequence();

    }
    public void printInstructions()
    {
        System.out.println("This is Blackjack!");
        System.out.println("The goal of the game is to get as close as possible to 21");
        System.out.println("without going over.");
        System.out.println("If you are closer to 21 than the dealer, you win!");
        System.out.println("If you go over 21 or are farther, you lose");
        System.out.println("Each round you can hit (get another card) as many times as you want");
        System.out.println("Or stand (take no more cards)");
        System.out.println("Note: Face cards are worth 10, numbers are their value");
        System.out.println("Good luck!");
        System.out.println();
        System.out.println("What is your name?");
        player = new Player(s.nextLine());
    }

    public void dealStartingHand()
    {
        deck.shuffle();
        player.addCard(deck.deal());
        player.addCard(deck.deal());

        dealer.addCard(deck.deal());
        dealer.addCard(deck.deal());
    }

    /*
    Plays game, asking player if they want more cards, ends when they go over 21 or decide to stop
     */
    public void playGame()
    {
        if(player.getPoints() >= 21 || (player.getPoints() + 10 == 21 && player.hasAce()))
        {
            return;
        }
        System.out.println(player.toStringHand());
        hitorstand = "o";
        while (!hitorstand.equals("h") && !hitorstand.equals("s") )
        {
            System.out.println("Hit(h) or stand(s)?");
            hitorstand = s.nextLine();
        }
        if (hitorstand.equals("h"))
        {
            player.addCard(deck.deal());
        }
        else
        {
            return;
        }
        this.playGame();
    }

    /*
    Adds cards to dealer until they have at least 17 or have lost
     */
    public void incrementDealer()
    {
        if (dealer.getPoints() < 17
        || dealer.hasAce() && dealer.getPoints() + 10 < 17)
        {

            dealer.addCard(deck.deal());
            this.incrementDealer();
        }
    }

    /*
    Prints if player won or lost, takes As into consideration
     */
    public void endSequence()
    {
        System.out.println(dealer.toStringHand());
        System.out.println(player.toStringHand());
        if (player.getPoints() > 21)
        {
            System.out.println("Bust!  You lose!");
            return;
        }
        if (dealer.getPoints() > 21)
        {
            System.out.println("The dealer busted!  You win!");
            return;
        }
        if(player.hasAce() && player.getPoints() + 10 <= 21)
        {
            player.addPoints(10);
        }
        if(dealer.hasAce() && dealer.getPoints() + 10 <= 21)
        {
            dealer.addPoints(10);
        }
        if (player.getPoints() == 21 || dealer.getPoints() == 21)
        {
            System.out.println("Blackjack!");
        }
        if(player.getPoints() > dealer.getPoints())
        {
            System.out.println("You win!");
            return;
        }
        if(player.getPoints() < dealer.getPoints())
        {
            System.out.println("You lose!");
            return;
        }
        else
        {
            System.out.println("Tie!");
        }
    }


}
