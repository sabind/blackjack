package com.noobathon.test;

import com.noobathon.blackjack.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest
{
	private Player player;
	private Player player2;

	@Before
	public void setUp() throws Exception
	{
		player = new HumanPlayer("Bill", 500);
		player2 = new HumanPlayer("bill", 500);
	}

	@Test
	public void testNewHandsStartOutEmpty()
	{
		player.newHand();
		assertTrue(player.isHandEmpty());
	}
	
	@Test
	public void testDealCarGivesThePlayerOnlyOneCard()
	{
		player.dealCard(new Card(13));
		assertEquals(1, player.getNumberOfCardsInHand());
	}
	
	@Test
	public void testHandsAddCardsCorrectly()
	{
		player.dealCard(new Card(13));
		assertEquals(10, player.getHandValue());
	}

	@Test
	public void testGetNameReturnsThePlayersNameCaseSensitive()
	{
		assertEquals("Bill", player.getName());
		assertEquals("bill", player2.getName());
	}

	@Test
	public void testToStringReturnsCorrectlyWithEmptyHand()
	{
		assertEquals("Bill: Current Hand: Empty Hand", player.toString());
	}
	
	@Test
	public void testToStringReturnsCorrectlyWithOneCardHand()
	{
		player.dealCard(new Card(3));
		
		assertEquals("Bill: Current Hand: 3", player.toString());
	}
	
	@Test
	public void testToStringReturnsCorrectlyWithTwoCardHand()
	{
		player.dealCard(new Card(3));
		player.dealCard(new Card(1));

		assertEquals("Bill: Current Hand: 3 A", player.toString());
	}
	
	@Test
	public void testToStringReturnsCorrectlyWithMultiCardHand()
	{
		player.dealCard(new Card(3));
		player.dealCard(new Card(12));
		player.dealCard(new Card(1));
		assertEquals("Bill: Current Hand: 3 Q A", player.toString());
	}

	@Test
	public void testShowTopCardOnlyReturnsCorrectlyWithEmptyHand()
	{
		assertEquals("Bill: Current Hand: Empty Hand", player.toString());
	}
	
	@Test
	public void testShowTopCardOnlyReturnsCorrectlyWithOneCardHand()
	{
		player.dealCard(new Card(3));
		assertEquals("Bill: Current Hand: 3", player.toStringShowingTopCardOnly());
	}
	
	@Test
	public void testShowTopCardOnlyReturnsCorrectlyWithTwoCardHand()
	{
		player.dealCard(new Card(3));
		player.dealCard(new Card(1));

		assertEquals("Bill: Current Hand: 3 X", player.toStringShowingTopCardOnly());
	}
	
	@Test
	public void testShowTopCardOnlyReturnsCorrectlyWithMultiCardHand()
	{
		player.dealCard(new Card(3));
		player.dealCard(new Card(12));
		player.dealCard(new Card(1));
		assertEquals("Bill: Current Hand: 3 X X", player.toStringShowingTopCardOnly());
	}

}
