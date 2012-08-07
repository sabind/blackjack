package com.noobathon.test;

import com.noobathon.blackjack.Action;
import com.noobathon.blackjack.Card;
import com.noobathon.blackjack.ComputerDealer;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

public class ComputerDealerTest extends EasyMockSupport
{
	private ComputerDealer hit;
	private ComputerDealer stay;
	private ComputerDealer onTheFence;
	
	private Card seven;
	private Card nine;
	private Card ten;
	private Card ace;

	@Before
	public void setUp() throws Exception
	{
		seven = createNiceMock(Card.class);
		EasyMock.expect(seven.getCardValue(EasyMock.anyBoolean())).andStubReturn(7);
		nine = createNiceMock(Card.class);
		EasyMock.expect(nine.getCardValue(EasyMock.anyBoolean())).andStubReturn(9);
		ten = createNiceMock(Card.class);
		EasyMock.expect(ten.getCardValue(EasyMock.anyBoolean())).andStubReturn(10);
		ace = createNiceMock(Card.class);
		EasyMock.expect(ace.getCardValue(true)).andStubReturn(1);
		EasyMock.expect(ace.getCardValue(false)).andStubReturn(11);
		
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
