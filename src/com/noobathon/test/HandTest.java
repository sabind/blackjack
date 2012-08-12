package com.noobathon.test;

import com.noobathon.blackjack.Hand;
import com.noobathon.blackjack.Card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

public class HandTest extends EasyMockSupport
{
	private Hand hand;
	private Card seven, nine, ten, jack, ace;

	@Before
	public void setUp() throws Exception
	{
		seven = createNiceMock(Card.class);
		EasyMock.expect(seven.getCardValue(EasyMock.anyBoolean())).andStubReturn(7);
		EasyMock.expect(seven.isAce()).andStubReturn(false);
		EasyMock.expect(seven.getCardString()).andStubReturn("7");
		nine = createNiceMock(Card.class);
		EasyMock.expect(nine.getCardValue(EasyMock.anyBoolean())).andStubReturn(9);
		EasyMock.expect(nine.isAce()).andStubReturn(false);
		EasyMock.expect(nine.getCardString()).andStubReturn("9");
		ten = createNiceMock(Card.class);
		EasyMock.expect(ten.getCardValue(EasyMock.anyBoolean())).andStubReturn(10);
		EasyMock.expect(ten.isAce()).andStubReturn(false);
		EasyMock.expect(ten.getCardString()).andStubReturn("10");
		jack = createNiceMock(Card.class);
		EasyMock.expect(jack.getCardValue(EasyMock.anyBoolean())).andStubReturn(10);
		EasyMock.expect(jack.isAce()).andStubReturn(false);
		EasyMock.expect(jack.getCardString()).andStubReturn("J");
		ace = createNiceMock(Card.class);
		EasyMock.expect(ace.isAce()).andStubReturn(true);
		EasyMock.expect(ace.getCardString()).andStubReturn("A");
		EasyMock.expect(ace.getCardValue(true)).andStubReturn(1);
		EasyMock.expect(ace.getCardValue(false)).andStubReturn(11);
		hand = new Hand();
	}

	@Test
	public void testAddCardAddsOneCardToTheHand()
	{
		replayAll();
		hand.addCard(seven);
		assertEquals(1 , hand.getNumberOfCards());
	}
	
	@Test
	public void testTotalHandValueAddsNumberCardsCorrectly()
	{
		replayAll();
		hand.addCard(ace);
		hand.addCard(nine);
		hand.addCard(seven);

		assertEquals(17, hand.getTotalHandValue());
	}
	
	@Test
	public void testTotalHandValueAddsTwoAcesCardsCorrectly()
	{
		replayAll();
		hand.addCard(ace);
		hand.addCard(ace);

		assertEquals(12, hand.getTotalHandValue());
	}
	
	@Test
	public void testTotalHandValueAddsJackQueenKingCardsCorrectly()
	{
		replayAll();
		hand.addCard(jack);
		hand.addCard(jack);
		hand.addCard(jack);

		assertEquals(30, hand.getTotalHandValue());
	}
	
	@Test
	public void testTotalHandValueAddsTwoCardBlackJackCorrectly()
	{
		replayAll();
		hand.addCard(ace);
		hand.addCard(jack);

		assertEquals(21, hand.getTotalHandValue());
	}
	
	@Test
	public void testTotalHandValueAddsThreeCardBlackJackCorrectly()
	{
		replayAll();
		hand.addCard(ace);
		hand.addCard(jack);
		hand.addCard(jack);
		
		assertEquals(21, hand.getTotalHandValue());
	}
	
	public void testAcesBustHandsCorrectly()
	{
		replayAll();
		hand.addCard(ace);
		hand.addCard(ace);
		hand.addCard(jack);
		hand.addCard(ten);
		
		assertEquals(22, hand.getTotalHandValue());
	}

	@Test
	public void testClearEmptiesAHand()
	{
		replayAll();
		hand.addCard(jack);
		hand.clear();
		assertTrue(hand.isHandEmpty());
	}

	@Test
	public void testToString()
	{
		replayAll();
		hand.addCard(seven);
		hand.addCard(ace);
		hand.addCard(jack);

		assertEquals("7 A J", hand.toString());
	}

	@Test
	public void testToStringShowingTopCardOnly()
	{
		replayAll();
		hand.addCard(seven);
		hand.addCard(ace);
		hand.addCard(jack);

		assertEquals("7 X X", hand.toStringShowingTopCardOnly());
	}

}
