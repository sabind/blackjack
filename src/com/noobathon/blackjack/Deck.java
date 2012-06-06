package com.noobathon.blackjack;

import java.util.Random;

public class Deck 
{
	private int deckIndex;
	private int cardsRemaining;

  // NOTE: Look at the naming convention of the following variables. These are constants. 
  // They are written in all CAPS with "_" as spaces between the words. Their easy to read
  // but also tells people that these numbers aren't changed by the code and where to find them
  // if they need to modify them. CONSTANTS are always are the beginning of the file.

  // We don't want to have "magic numbers" in the code. It make it hard to change if we need to 
  // change the decksize we need to do it every time we see "52". Also someone may have added
  // another place using this "deck_size" if they had used a magic number and we didn't know 
  // about their change then we'd introduce a bug by forgeting to change it. 
  //
  // This way we only need to change this variable once and it makes all the changes for us. 
  public final int DECK_SIZE = 52;

  // Even though this variable is only used twice, unlike deck_size, it's good to have a final
  // here too becaus it allows us to change the value without looking through the file for the
  // place where we actually use the variable. It's easier to maintain this way.
  public final int TIMES_TO_SHUFFLE = 15;

  public final int NUMBER_OF_SUITS = 4;
	
	private Card[] cards;
	
	public Deck ()
	{
		deckIndex = 0;
		cardsRemaining = DECK_SIZE;
		
		cards = new Card[DECK_SIZE];
		
		generateDeck();
		shuffle(TIMES_TO_SHUFFLE);
	}
	
	public int numCardsRemaining()
	{
		return cardsRemaining;
	}
	
	public Card removeCard()
	{
		if (cardsRemaining == 0)
			return null;
		
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
			int fromIndex = randomGenerator.nextInt(DECK_SIZE);
			int toIndex = randomGenerator.nextInt(DECK_SIZE);
			
			Card temp = cards[fromIndex];
			cards[fromIndex] = cards[toIndex];
			cards[toIndex] = temp;
		}
		
	}
	
	private void generateDeck()
	{
		deckIndex = 0;
	  
    //NOTE: Look at the use of constants here. It makes the loops much easier to read. 
    //No comments are required to explain what this loops is trying to do in terms of the 
    //number of iterations it's aiming to complete.
      
		for (int i = 0; i < NUMBER_OF_SUITS; ++i)
		{
			for (int j = 1; j <= DECK_SIZE%NUMBER_OF_SUITS; ++j)
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
		shuffle(TIMES_TO_SHUFFLE);
		cardsRemaining = DECK_SIZE;
	}
	
}
