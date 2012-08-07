package com.noobathon.test;

import com.noobathon.blackjack.ComputerDealer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ComputerDealerTest
{
	private ComputerDealer hit;
	private ComputerDealer stay;
	private ComputerDealer onTheFence;

	@Before
	public void setUp() throws Exception
	{
		
		hit = new ComputerDealer("hit");
		hit.dealCard(new Card(7));
		hit.dealCard(new Card(9));
		
		onTheFence = new ComputerDealer("on the edge");
		onTheFence.dealCard(new Card(10));
		onTheFence.dealCard(new Card(7));
		
		stay = new ComputerDealer("stay");
		stay.dealCard(new Card(10));
		stay.dealCard(new Card(1));
	}

	@Test
	public void testDealerHitsWhenBelowSeventeen()
	{
		assertEquals(Action.Hit, hit.takeAction());
	}
	
	@Test
	public void testDealerStaysWhenAboveSeventeen()
	{
		assertEquals(Action.Stay, stay.takeAction());
	}
	
	@Test
	public void testDealerStaysWhenAtSeventeen()
	{
		assertEquals(Action.Stay, onTheFence.takeAction());
	}	
}
