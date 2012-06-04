package com.noobathon.blackjack;

import java.util.Random;

public class Deck 
{
	private int deckIndex;
	private int cardsRemaining;
	
	private Card[] cards;
	
	public Deck ()
	{
		deckIndex = 0;
		cardsRemaining = 52;
		
		cards = new Card[52];
		
		generateDeck();
		shuffle(15);
	}
	
	public int numCardsRemaining()
	{
		return cardsRemaining;
	}
	
	public Card removeCard()
	{
		cardsRemaining--;
		Card rtn = cards[deckIndex];
		deckIndex++;
		return rtn;
	}
	
	private void shuffle(int numShuffles)
	{
		Random randomGenerator = new Random();
		for (int i = 0; i < numShuffles; ++i)
		{
			int fromIndex = randomGenerator.nextInt(52);
			int toIndex = randomGenerator.nextInt(52);
			
			Card temp = cards[fromIndex];
			cards[fromIndex] = cards[toIndex];
			cards[toIndex] = temp;
		}
		
	}
	
	private void generateDeck()
	{
		deckIndex = 0;
		
		for (int i = 0; i < 4; ++i)
		{
			for (int j = 1; j < 14; ++j)
			{
				cards[deckIndex] = new Card(j);
				deckIndex++;
			}
		}
		
		deckIndex = 0;
	}
	
	public void newDeck()
	{
		generateDeck();
		shuffle(15);
		cardsRemaining = 52;
	}
	
}
