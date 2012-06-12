package com.noobathon.blackjack;

import java.util.ArrayList;

public class Game {

	public Deck deck;

    private ComputerDealer dealer;
    private ArrayList<HumanPlayer> players;

	public Game()
    {
        String[] playerNames = {"Dan"};

		deck = new Deck();
        dealer = new ComputerDealer("Joe");
        players = new ArrayList<HumanPlayer>();

        for (String name : playerNames)
        {
            players.add(new HumanPlayer(name, 1000));
        }
	}

    public void dealCards()
    {
        for (int i = 0; i < 2; ++i)
        {
            dealer.dealCard(deck.removeCard());

            for (HumanPlayer player : players)
            {
                player.dealCard(deck.removeCard());
            }
        }
    }

    public void playRound()
    {
        while (dealer.needsMoreCards())
        {
            if (dealer.takeAction().equals(Action.Hit))
                dealer.dealCard(deck.removeCard());
        }

        for (HumanPlayer player : players)
        {
            player.betChips(10);

            while (player.getHandValue() < 17)
                player.dealCard(deck.removeCard());

            if ((dealer.getHandValue() > 21 || player.getHandValue() > dealer.getHandValue()) && player.getHandValue() < 22)
                player.winBet();
            else
                player.loseBet();

            System.out.println(player.getName() + " has " + player.getChipCount() + "chips.");
        }

        System.out.println(dealer);
        dealer.tossHand();

        for (HumanPlayer player : players)
        {
            System.out.println(player);
            player.tossHand();
        }
    }

    public HumanPlayer[] getPlayers()
    {
        return (HumanPlayer[]) players.toArray();
    }

	public Deck getDeck() 
	{
		return deck;
	}

    public static void main(String[] args)
    {
        Game theGame= new Game();
        while (theGame.deck.numCardsRemaining() > 6)
        {
            theGame.dealCards();
            theGame.playRound();
        }
    }
}
