package com.noobathon.test;

import com.noobathon.blackjack.Deck;
import com.noobathon.blackjack.Card;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest
{
	private Deck deck;

	@Before
	public void setUp() throws Exception
	{
		deck = new Deck();
	}

	@Test
	public void decksShouldHaveFiftyTwoCards()
	{
		assertEquals(52, deck.numCardsRemaining());
	}
	
	@Test
	public void removingCardFromEmptyDeckShouldNotThrowExpeption()
	{
		boolean thrown = false;

		try 
		{
			for (int i = 0; i < 53; ++i)
			{
				deck.removeCard();
			}
		}
		catch (IndexOutOfBoundsException e) 
		{
		    thrown = true;
		}
		
		assertEquals(0, deck.numCardsRemaining());
		assertFalse(thrown);
	}
	
	@Test
	public void testDeckIsCompleteFiftyTwoCardDeck()
	{
		testDeckForCompleteness();
	}
	
	@Test
	public void testNewDeckMakesANewFiftyTwoCardDeck()
	{
		deck.newDeck();
		assertTrue(deck.numCardsRemaining() == 52);
	}
	
	@Test
	public void testNewDeckMakesANewCompleteFiftyTwoCardDeck()
	{
		deck.newDeck();
		testDeckForCompleteness();
	}

	private void testDeckForCompleteness() 
	{
		int threeCount = 0;
		int jackCount = 0;
		int aceCount = 0;
		
		for (int i = 0; i < 52; i++)
		{
			Card card = deck.removeCard();
			if (card.toString().equals("3"))
				threeCount++;
			if (card.toString().equals("J"))
				jackCount++;
			if (card.toString().equals("A"))
				aceCount++;

			// Use this to check your deck is shuffled
			//System.out.println(card);
		}
		assertTrue(threeCount == 4);
		assertTrue(jackCount == 4);
		assertTrue(aceCount == 4);
	}

}
