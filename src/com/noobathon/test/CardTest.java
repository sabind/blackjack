package com.noobathon.test;

import com.noobathon.blackjack.Card;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CardTest
{
	private Card number;
	private Card ace;
	private Card jack;
	private Card queen;
	private Card king;

	@Before
	public void setUp()
	{
		number = new Card(3);
		jack = new Card(11);
		queen = new Card(12);
		king = new Card(13);
		ace = new Card(1);
	}

	@Test
	public void aceShouldBeWorthOnePointWhenAceIsLow()
	{
		boolean acesLow = true;
		assertEquals(1, ace.getCardValue(acesLow));	
	}
	
	@Test
	public void aceShouldBeWorthElevenPointsWhenAceIsHigh()
	{
		boolean acesLow = false;
		assertEquals(11, ace.getCardValue(acesLow));	
	}
	
	@Test
	public void jackCardShouldBeWorthTenPointsWhenAceIsHighOrLow()
	{
		boolean acesLow = true;
		assertEquals(10, jack.getCardValue(acesLow));	
		
		acesLow = false;
		assertEquals(10, jack.getCardValue(acesLow));
	}
	
	@Test
	public void queenCardShouldBeWorthTenPointsWhenAceIsHighOrLow()
	{
		boolean acesLow = true;
		assertEquals(10, queen.getCardValue(acesLow));	
		
		acesLow = false;
		assertEquals(10, queen.getCardValue(acesLow));
	}
	
	@Test
	public void kingCardShouldBeWorthTenPointsWhenAceIsHighOrLow()
	{
		boolean acesLow = true;
		assertEquals(10, king.getCardValue(acesLow));	
		
		acesLow = false;
		assertEquals(10, king.getCardValue(acesLow));
	}
	
	@Test
	public void numberCardsShouldBeWorthTheirValueWhenAceIsHighOrLow()
	{
		boolean acesLow = true;
		assertEquals(3, number.getCardValue(acesLow));

		acesLow = false;
		assertEquals(3, number.getCardValue(acesLow));
	}

	@Test
	public void aceToStringShouldBeA()
	{
		assertEquals("A", ace.toString());
	}
	
	@Test
	public void jackToStringShouldBeJ()
	{
		assertEquals("J", jack.toString());
	}
	
	@Test
	public void queenToStringShouldBeQ()
	{
		assertEquals("Q", queen.toString());
	}
	
	@Test
	public void kingToStringShouldBeK()
	{
		assertEquals("K", king.toString());
	}
	
	@Test
	public void numberCardToStringTheSameNumber()
	{
		assertEquals("3", number.toString());
	}

}
