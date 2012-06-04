package com.noobathon.test;

import com.noobathon.blackjack.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HandTest
{
	private Hand hand;

	@Before
	public void setUp() throws Exception
	{
		hand = new Hand();
	}

	@Test
	public void testAddCardAddsOneCardToTheHand()
	{
		hand.addCard(new Card(3));
		assertEquals(1 , hand.getNumberOfCards());
	}
	
	@Test
	public void testTotalHandValueAddsNumberCardsCorrectly()
	{
		hand.addCard(new Card(3));
		hand.addCard(new Card(4));
		hand.addCard(new Card(5));

		assertEquals(12, hand.getTotalHandValue());
	}
	
	@Test
	public void testTotalHandValueAddsTwoAcesCardsCorrectly()
	{
		hand.addCard(new Card(1));
		hand.addCard(new Card(1));

		assertEquals(12, hand.getTotalHandValue());
	}
	
	@Test
	public void testTotalHandValueAddsJackQueenKingCardsCorrectly()
	{
		hand.addCard(new Card(11));
		hand.addCard(new Card(12));
		hand.addCard(new Card(13));

		assertEquals(30, hand.getTotalHandValue());
	}
	
	@Test
	public void testTotalHandValueAddsTwoCardBlackJackCorrectly()
	{
		hand.addCard(new Card(1));
		hand.addCard(new Card(12));

		assertEquals(21, hand.getTotalHandValue());
	}
	
	@Test
	public void testTotalHandValueAddsThreeCardBlackJackCorrectly()
	{
		hand.addCard(new Card(1));
		hand.addCard(new Card(12));
		hand.addCard(new Card(13));
		
		assertEquals(21, hand.getTotalHandValue());
	}
	
	public void testAcesBustHandsCorrectly()
	{
		hand.addCard(new Card(1));
		hand.addCard(new Card(1));
		hand.addCard(new Card(12));
		hand.addCard(new Card(13));
		
		assertEquals(22, hand.getTotalHandValue());
	}

	@Test
	public void testClearEmptiesAHand()
	{
		hand.addCard(new Card(12));

		hand.clear();
		assertTrue(hand.isHandEmpty());
	}

	@Test
	public void testToString()
	{
		hand.addCard(new Card(3));
		hand.addCard(new Card(1));
		hand.addCard(new Card(12));

		assertEquals("3 A Q", hand.toString());
	}

	@Test
	public void testToStringShowingTopCardOnly()
	{
		hand.addCard(new Card(3));
		hand.addCard(new Card(1));
		hand.addCard(new Card(12));

		assertEquals("3 X X", hand.toStringShowingTopCardOnly());
	}

}
