package com.noobathon.test;

import com.noobathon.blackjack.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HumanPlayerTest
{
	private HumanPlayer player;

	@Before
	public void setUp() throws Exception
	{
		player = new HumanPlayer("me", 500);
	}

	@Test
	public void testGetChipCountReturnsCorrectChipAmount()
	{
		assertEquals(500, player.getChipCount());
	}

	@Test
	public void testWinBetIncrementsChipCountByBetAmount()
	{
		player.betChips(100);
		player.winBet();
		assertTrue(player.getChipCount() == 600);
	}
	
	@Test
	public void testPlayerCanNotBetMoreChipsThanCurrentChipAmount()
	{
		player.betChips(700);
		player.winBet();
		
		//Player can only be at 1000 chips since he only had 500 to bet
		assertTrue(player.getChipCount() == 1000);
	}

	@Test
	public void testLoseBetDecrementsChipCountByBetAmount()
	{
		player.betChips(30);
		player.loseBet();
		assertEquals(470 , player.getChipCount());
	}
	
	@Test
	public void testPlayerCanNotHaveNegativeChipCount()
	{
		player.betChips(700);
		player.loseBet();
		assertEquals(0 , player.getChipCount());
	}

}
