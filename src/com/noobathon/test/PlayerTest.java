package com.noobathon.test;

import com.noobathon.blackjack.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest
{
	private Player player;

	@Before
	public void setUp() throws Exception
	{
		player = new HumanPlayer("me", 500);
	}

	@Test
	public void testNewHand()
	{
		player.dealCard(new Card(13));
		assertTrue(player.getHandValue() == 10);

		player.newHand();
		assertTrue(player.getHandValue() == 0);
	}

	@Test
	public void testDealCard()
	{
		player.dealCard(new Card(13));
		assertTrue(player.getHandValue() == 10);
	}

	@Test
	public void testGetName()
	{
		assertTrue(player.getName().equals("me"));
	}

	@Test
	public void testToString()
	{
		assertEquals("me: Current Hand: Empty Hand", player.toString());

		player.dealCard(new Card(3));
		player.dealCard(new Card(1));

		assertEquals("me: Current Hand: 3 A", player.toString());
	}

	@Test
	public void testToStringShowingTopCardOnly()
	{
		assertEquals("me: Current Hand: Empty Hand", player.toStringShowingTopCardOnly());

		player.dealCard(new Card(3));
		player.dealCard(new Card(1));

		assertEquals("me: Current Hand: 3 X", player.toStringShowingTopCardOnly());
	}

}
