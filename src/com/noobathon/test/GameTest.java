package com.noobathon.test;

import com.noobathon.blackjack.*;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTest
{
	private Game game;

	@Before
	public void setUp() throws Exception
	{
		game = new Game();
	}

	@Test
	public void testGetDeck()
	{
		assertEquals(52, game.getDeck().numCardsRemaining());
	}

}
