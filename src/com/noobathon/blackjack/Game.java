package com.noobathon.blackjack;

public class Game {

	private Deck deck;
	
	public Game()
	{
		deck = new Deck();
	}
	
	public Deck getDeck() 
	{
		return deck;
	}

}
